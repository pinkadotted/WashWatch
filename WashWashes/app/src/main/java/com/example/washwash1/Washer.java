package com.example.washwash1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Washer extends Machine {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText reporter_name, reporter_hp, fault_description;
    private Button cancel_report, save_report;

    RecyclerView recyclerView;

//    String s1[], s2[];
    int images[] = {R.drawable.redmachine, R.drawable.redmachine, R.drawable.redmachine,
            R.drawable.greenmachine, R.drawable.greenmachine, R.drawable.greenmachine,
            R.drawable.redmachine, R.drawable.redmachine, R.drawable.redmachine,
            R.drawable.greenmachine, R.drawable.greenmachine, R.drawable.greenmachine};

    public String[] getMachines() {
        return getResources().getStringArray(R.array.washers);
    }
    public String[] getMachineTimes() {
        return getResources().getStringArray(R.array.washers_times);
    }
    public int getActivityLayout() {
        return R.layout.activity_washer;
    }
    public int getMachineId() {
        return R.id.washer;
    }
    public int getOtherId(){
        return R.id.dryer;
    }
    public Class goToClass() {
        return Dryer.class;
    }

    // to ensure that the app goes to Washer when the android back button is pressed
//    @Override
//    public void onBackPressed() {
//        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        finish();
//    }


    // Abstract Base Class implementation only works with OnCreate method in child class
    // Does not work if moved into Machine.java abstract base class
    // Implementation in both Dryer and Machine identical
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());

        recyclerView = findViewById(R.id.recyclerView);

//        s1 = getResources().getStringArray(R.array.washers);
//        s2 = getResources().getStringArray(R.array.washers_times);

        MyAdapter myAdapter = new MyAdapter(this, getMachines(), getMachineTimes(), images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(getMachineId());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.dryer:
//                        startActivity(new Intent(getApplicationContext(), Dryer.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.washer:
//                        return true;
//                }
                if (menuItem.getItemId()==getOtherId()) {
                    startActivity(new Intent(getApplicationContext(), goToClass()));
                    overridePendingTransition(0,0);
                    return true;
                }
                else if (menuItem.getItemId()==getMachineId()) {
                    return true;
                }
                return false;
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            createNewReport();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    // start of method for creating popup form
//    public void createNewReport() {
//        dialogBuilder = new AlertDialog.Builder(this);
//        final View reportPopUp = getLayoutInflater().inflate(R.layout.report_dryer_popup, null);
//        fault_description = (EditText) reportPopUp.findViewById(R.id.fault_description);
//        reporter_name = (EditText) reportPopUp.findViewById(R.id.reporter_name);
//        reporter_hp = (EditText) reportPopUp.findViewById(R.id.reporter_hp);
//
//        save_report = (Button) reportPopUp.findViewById(R.id.save_report);
//        cancel_report = (Button) reportPopUp.findViewById(R.id.cancel_report);
//
//        dialogBuilder.setView(reportPopUp);
//        dialog = dialogBuilder.create();
//        dialog.show();
//
//        save_report.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // define save button here!
//                dialog.dismiss();
//            }
//        });
//
//        cancel_report.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//    }

}