package com.example.washwash1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Logcat";

    // when the back button is pressed, we want to close the app
    private long pressedTime = 0;
    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
            moveTaskToBack(true);
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.getInstance();

        String[] blocks = new String[] {"55", "57", "59"};
        Button[] hostel = new Button[blocks.length];

        for(int idx=0; idx < blocks.length; idx++){
            String buttonID = "block"+blocks[idx];
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            hostel[idx] = ((Button) findViewById(resID));
            String ID = hostel[idx].getText().toString();
            hostel[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Firebase.setBlock(ID.substring(ID.length()-2));
                    startActivity(new Intent(MainActivity.this, Washer.class));
                }
            });
        }
    }
}
