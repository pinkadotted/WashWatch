package com.example.washwash1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
// import android.widget.ImageButton;
// import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
// import com.google.firebase.database.DataSnapshot;
// import com.google.firebase.database.DatabaseError;
// import com.google.firebase.database.DatabaseReference;
// import com.google.firebase.database.FirebaseDatabase;
// import com.google.firebase.database.ValueEventListener;

// import java.util.ArrayList;

public class Dryer extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText reporter_name, reporter_hp, fault_description;
    private Button cancel_report, save_report;

    DatabaseReference mRootDatabaseRef;
    DatabaseReference mNodeRef;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView retrieveTV;

    // creating 12 report_buttons
//    ImageButton report_dryer_1, report_dryer_2, report_dryer_3, report_dryer_4, report_dryer_5, report_dryer_6, report_dryer_7, report_dryer_8, report_dryer_9, report_dryer_10, report_dryer_11, report_dryer_12;

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
        setContentView(R.layout.activity_dryer);

        recyclerView = findViewById(R.id.recyclerView2);

        s1 = getResources().getStringArray(R.array.dryers);
        s2 = getResources().getStringArray(R.array.dryers_times);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        // bottom navigation bar section
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.dryer);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dryer:
                        return true;
                    case R.id.washer:
                        startActivity(new Intent(getApplicationContext(), Washer.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference().child("dryer1");
////        retrieveTV = findViewById(R.id.dryer1timing);
//        getData();
//        databaseReference.setValue("99 mins");

//        ArrayList<ImageButton> report_dryer_buttons_list = new ArrayList();
//        report_dryer_buttons_list.add(report_dryer_1);

        // create some kind of for loop to simplify the instantiation below
//        report_dryer_1 = findViewById(R.id.report_dryer_1);
//        report_dryer_2 = findViewById(R.id.report_dryer_2);
//        report_dryer_3 = findViewById(R.id.report_dryer_3);
//        report_dryer_4 = findViewById(R.id.report_dryer_4);
//        report_dryer_5 = findViewById(R.id.report_dryer_5);
//        report_dryer_6 = findViewById(R.id.report_dryer_6);
//        report_dryer_7 = findViewById(R.id.report_dryer_7);
//        report_dryer_8 = findViewById(R.id.report_dryer_8);
//        report_dryer_9 = findViewById(R.id.report_dryer_9);
//        report_dryer_10 = findViewById(R.id.report_dryer_10);
//        report_dryer_11 = findViewById(R.id.report_dryer_11);
//        report_dryer_12 = findViewById(R.id.report_dryer_12);


        // only created 4 so far
//        report_dryer_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(Dryer.this, report_dryer_1);
//
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_example, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        // display a textbox asking for a description of the fault in the machine
//                        createNewReport();
//                        return true;
//                    }
//                });
//                popupMenu.show();
//            }
//        });

//        report_dryer_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(Dryer.this, report_dryer_2);
//
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_example, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        // display a textbox asking for a description of the fault in the machine
//                        createNewReport();
//                        return true;
//                    }
//                });
//                popupMenu.show();
//            }
//        });
//
//        report_dryer_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(Dryer.this, report_dryer_3);
//
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_example, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        // display a textbox asking for a description of the fault in the machine
//                        createNewReport();
//                        return true;
//                    }
//                });
//                popupMenu.show();
//            }
//        });
//
//        report_dryer_4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu = new PopupMenu(Dryer.this, report_dryer_4);
//
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_example, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        // display a textbox asking for a description of the fault in the machine
//                        createNewReport();
//                        return true;
//                    }
//                });
//                popupMenu.show();
//            }
//        });

    }

//    private void getData(){
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Long value = snapshot.getValue(Long.class);
//                retrieveTV.setText(value.toString() + "min");
//                //toast line for debug purposes
//                Toast.makeText(Dryer.this, "onDataChange was called!", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(Dryer.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

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
    // end of method for creating popup form

}
