package com.example.washwash1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.core.Repo;

import java.util.ArrayList;

public class Machines extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText reporter_name, reporter_hp, fault_description, machine_id; // added machine_id


    private Button cancel_report, save_report;
    public static final String TAG = "Logcat_Washer";

    public static RecyclerView recyclerView;
    public static MyAdapter myAdapter;
    public static GridLayoutManager gridLayoutManager;
    static int[] washer_images = {R.drawable.redmachine, R.drawable.yellowmachine, R.drawable.greenmachine };
    static int[] dryer_images = {R.drawable.dryer_red, R.drawable.dryer_yellow, R.drawable.dryer_green };
    static int[] images;

    // to ensure that the app goes to Washer when the android back button is pressed
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer);

        //Pulling Data from Firebase
        Firebase.pullFromCloud();

        //Setting up recycle view, and the number of cards is dependent on the Firebase
        recyclerView = findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(this, Firebase.getArray("names").toArray(new String[0]), Firebase.getArray("time").toArray(new String[0]), images);
        gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.washer);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dryer:
                        Firebase.setMachine("Dryers");
                        Firebase.pullFromCloud();
                        return true;
                    case R.id.washer:
                        Firebase.setMachine("Washers");
                        Firebase.pullFromCloud();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
        machine_id = (EditText) reportPopUp.findViewById(R.id.machine_id);

        save_report = (Button) reportPopUp.findViewById(R.id.save_report);
        cancel_report = (Button) reportPopUp.findViewById(R.id.cancel_report);

        dialogBuilder.setView(reportPopUp);
        dialog = dialogBuilder.create();
        dialog.show();

        save_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Report make_report = new Report(machine_id.getText().toString(), fault_description.getText().toString(), reporter_name.getText().toString(), reporter_hp.getText().toString());
                if (make_report.isEmpty()){
                    Toast toast = Toast.makeText(Machines.this, R.string.warning_blank_edit_text, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Firebase.Report(make_report);
                    Toast toast = Toast.makeText(Machines.this, R.string.submit_text, Toast.LENGTH_SHORT);
                    toast.show();
                    dialog.dismiss();
                }
                // define save button here!
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