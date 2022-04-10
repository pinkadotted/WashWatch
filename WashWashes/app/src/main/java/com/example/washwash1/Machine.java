package com.example.washwash1;
// Abstract Machine Class
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class Machine extends AppCompatActivity {
    protected AlertDialog.Builder dialogBuilder;
    protected AlertDialog dialog;
    protected EditText reporter_name, reporter_hp, fault_description;
    protected Button cancel_report, save_report;

//    RecyclerView recyclerView;

    int images[] = {R.drawable.redmachine, R.drawable.redmachine, R.drawable.redmachine,
            R.drawable.greenmachine, R.drawable.greenmachine, R.drawable.greenmachine,
            R.drawable.redmachine, R.drawable.redmachine, R.drawable.redmachine,
            R.drawable.greenmachine, R.drawable.greenmachine, R.drawable.greenmachine};

    public abstract String[] getMachines();
    public abstract String[] getMachineTimes();
    public abstract int getOtherId(); // If Washer return Dryer and vice versa
    public abstract Class goToClass(); // If Washer return Dryer class vice versa
    public abstract int getActivityLayout();
    public abstract int getMachineId();


    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), goToClass()));
        finish();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(getActivityLayout());
//
//        recyclerView = findViewById(R.id.recyclerView);
//
//        MyAdapter myAdapter = new MyAdapter(this, getMachines(), getMachineTimes(), images);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(getMachineId());
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
////                switch (menuItem.getItemId()){
////                    case R.id.dryer:
////                        startActivity(new Intent(getApplicationContext(), Dryer.class));
////                        overridePendingTransition(0,0);
////                        return true;
////                    case R.id.washer:
////                        return true;
////                }
//                if (menuItem.getItemId()==getOtherId()) {
//                    startActivity(new Intent(getApplicationContext(), goToClass()));
//                    overridePendingTransition(0,0);
//                    return true;
//                }
//                else if (menuItem.getItemId()==getMachineId()) {
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

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
