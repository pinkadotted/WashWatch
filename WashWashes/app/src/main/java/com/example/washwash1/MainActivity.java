package com.example.washwash1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Logcat";

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText reporter_name, reporter_hp, fault_description;
    private Button cancel_report, save_report;

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
                    if (Firebase.getInstance().isNetworkAvailable(getApplicationContext())) {
                        Firebase.setBlock(ID.substring(ID.length() - 2));
                        Firebase.setMachine("Washers");
                        startActivity(new Intent(MainActivity.this, Machines.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Please connect to internet to view machine statuses", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            createNewReport();
        }
        return super.onOptionsItemSelected(item);
    }

    // start of method for creating popup form
    public void createNewReport() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View reportPopUp = getLayoutInflater().inflate(R.layout.report_dryer_popup, null);
        fault_description = (EditText) reportPopUp.findViewById(R.id.fault_description);
        reporter_name = (EditText) reportPopUp.findViewById(R.id.reporter_name);
        reporter_hp = (EditText) reportPopUp.findViewById(R.id.reporter_hp);

        save_report = (Button) reportPopUp.findViewById(R.id.save_report);
        cancel_report = (Button) reportPopUp.findViewById(R.id.cancel_report);

        dialogBuilder.setView(reportPopUp);
        dialog = dialogBuilder.create();
        dialog.show();

        save_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // define save button here!
                dialog.dismiss();
            }
        });

        cancel_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
