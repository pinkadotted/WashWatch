package com.example.washwash1;

import android.content.Context;
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

import java.util.ArrayList;

public class Firebase {

    private static Firebase instance = null;
    private static String block;
    static final String UTILS_TAG = "Logcat_FireBase";
    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;

    private Firebase(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
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

    public static String getBlock(){
        return block;
    }

    static ArrayList<String> arrayList = new ArrayList<>();

    public static DatabaseReference setView(TextView v, String machine){
        Log.i(UTILS_TAG, "View is set");
        DatabaseReference another = databaseReference.child(block).child(machine);
        another.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue(String.class);
                v.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return databaseReference.child(block).child("dryer1");
    }
}
