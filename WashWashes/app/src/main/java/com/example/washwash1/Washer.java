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

public class Washer extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText reporter_name, reporter_hp, fault_description;
    private Button cancel_report, save_report;

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.redmachine, R.drawable.redmachine, R.drawable.redmachine,
            R.drawable.greenmachine, R.drawable.greenmachine, R.drawable.greenmachine,
            R.drawable.redmachine, R.drawable.redmachine, R.drawable.redmachine,
            R.drawable.greenmachine, R.drawable.greenmachine, R.drawable.greenmachine};

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

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.washers);
        s2 = getResources().getStringArray(R.array.washers_times);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.washer);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dryer:
                        startActivity(new Intent(getApplicationContext(), Dryer.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.washer:
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