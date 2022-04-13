package com.example.washwash1;

import static org.junit.Assert.assertEquals;

import android.util.Log;

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

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FirebaseUnitTest {

    private static Firebase instance = null;
    private static String block = "55";
    private static String machine = "Dryers";
    static final String UTILS_TAG = "Logcat_FireBase";
    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<String> time = new ArrayList<>();
    private static String value;
    private static int i;

    @Test
    public void pull_firebase_correctly() {
        DatabaseReference database = databaseReference.child(block).child(machine);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i(UTILS_TAG, "onChange");
                names.clear();
                time.clear();
                DataSnapshot child = snapshot.getChildren().iterator().next();
                value = child.getValue(String.class);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });

        assertEquals(value, "10 min");
    }
}