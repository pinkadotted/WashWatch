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
    private static String machine;
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
                i = 1;
                for (DataSnapshot c: snapshot.getChildren()){
                    i += 1;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Log.d(UTILS_TAG, "connected");
                } else {
                    Log.d(UTILS_TAG, "not connected");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(UTILS_TAG, "Listener was cancelled");
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

    public static void setMachine(String m){
        machine = m;
        Log.i(UTILS_TAG, m);
    }

    public static String getMachine(){
        return machine;
    }

    public static void Report(String machine_id, String fault, String name, String hp){
        DatabaseReference report = submit.child(String.valueOf(i));
        report.child("Machine ID").setValue(machine_id);
        report.child("Name").setValue(name);
        report.child("Phone number").setValue(hp);
        report.child("Description").setValue(fault);
        Log.i(UTILS_TAG, "Report submitted");
    }

    public static void pullFromCloud(){
        Log.i(UTILS_TAG, "Pulling from firebase " + block + " " +  machine);
        DatabaseReference database = databaseReference.child(block).child(machine);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i(UTILS_TAG, "onChange");
                names.clear();
                time.clear();
                for (DataSnapshot child : snapshot.getChildren()) {

                    String key = child.getKey();
                    String value = child.getValue(String.class);

                    if(value != null){
                        //System.out.println(post);
                        names.add(key);
                        time.add(value);
                    }
                }
                Log.i(UTILS_TAG, names.toString());
                Log.i(UTILS_TAG, time.toString());
                Machines.myAdapter.update();
                Machines.recyclerView.setAdapter(Machines.myAdapter);
                Machines.recyclerView.setLayoutManager(Machines.gridLayoutManager);
                Log.i(UTILS_TAG, "End of pulling");
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
