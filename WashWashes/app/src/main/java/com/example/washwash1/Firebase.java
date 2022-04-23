package com.example.washwash1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Firebase{

    private static Firebase instance = null;
    private static String block;
    private static String machineType;
    static final String UTILS_TAG = "Logcat_FireBase";
    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<String> time = new ArrayList<>();
    private static DatabaseReference submit;
    private static int i;

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private Firebase(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        submit = databaseReference.child("Report");
        submit.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                i = 0;
                for (DataSnapshot c: snapshot.getChildren()){
                    int value = Integer.parseInt(c.getKey());
                    if (value >= i){
                        i = value + 1;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public static Firebase getInstance(){
        Log.i(UTILS_TAG, "Firebase has been instantiated");
        if(instance == null){
            instance = new Firebase();
        }
        return instance;
    }

    public static void setBlock(String n){
        block = n;
        Log.i(UTILS_TAG, n);
    }

    public static void setMachineType(String m){
        machineType = m;
        Log.i(UTILS_TAG, m);
        if (m.equals("Washers")){
            Log.i(UTILS_TAG, "Images set to washer");
            Machines.images = Machines.washer_images;
        }
        else if (m.equals("Dryers")){
            Log.i(UTILS_TAG, "Images set to dryer");
            Machines.images = Machines.dryer_images;
        }
    }

    public static String getMachineType(){
        return machineType;
    }

    public static String getBlock(){
        return block;
    }

    public static void Report(Report make_report){
        DatabaseReference report = submit.child(String.valueOf(i));
        report.setValue(make_report);
        Log.i(UTILS_TAG, String.valueOf(i));
        Log.i(UTILS_TAG, "Report submitted");
    }

    public static void pullFromCloud(String machine){
        setMachineType(machine);
        Log.i(UTILS_TAG, "Pulling from firebase block " + block + " " +  machineType);
        DatabaseReference database = databaseReference.child(block).child(machineType);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Log.i(UTILS_TAG,"my database is " + databaseReference.child(block).toString());
                Log.i(UTILS_TAG, "Database from snapshot is " + snapshot.getRef().getParent().getKey());
                Log.i(UTILS_TAG,"my current machine type is " + machineType);
                if (snapshot.getKey().equals(machineType) && snapshot.getRef().getParent().getKey().equals(block)){
                    Log.i(UTILS_TAG, "onChange");
                    names.clear();
                    time.clear();
                    Log.i(UTILS_TAG, snapshot.toString());
                    for (DataSnapshot child : snapshot.getChildren()) {
                        long value = child.child("default_time_end").getValue(Long.class);
                        long timeleft = (value*1000 - System.currentTimeMillis())/60000;
                        if (timeleft < 0){
                            timeleft = 0L;
                        }

                        String key = child.getKey();

                        names.add(key);
                        time.add(Long.toString(timeleft) + " min");
                    }
                    Machines.myAdapter.update();
                    Machines.recyclerView.setAdapter(Machines.myAdapter);
                    Machines.recyclerView.setLayoutManager(Machines.gridLayoutManager);
                    Log.i(UTILS_TAG, "End of pulling");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(UTILS_TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public static ArrayList<String> getArray(String type){
        if (type.equals("names")){
            return names;
        }
        else if (type.equals("time")){
            return time;
        }
        return new ArrayList<>();
    }
}
