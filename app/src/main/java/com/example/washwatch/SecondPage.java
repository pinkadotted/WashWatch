package com.example.washwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;

public class SecondPage extends AppCompatActivity {

    ImageButton red_washer1;
    ImageButton green_washer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

//        red_washer1 = findViewById(R.id.red_washer1);
//        green_washer = findViewById(R.id.green_washer);
//        red_washer1.setBackground(null);
//        green_washer.setBackground(null);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

    }
}