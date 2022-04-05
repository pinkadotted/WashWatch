package com.example.washwash1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Washer extends AppCompatActivity {

    RecyclerView recyclerView;

//    List<String> s1;
//    List<String> s2;
//    List<Integer> images;

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
}