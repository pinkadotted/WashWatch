package com.example.washwash1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton androidImageButton;
    ImageButton androidImageButton1;
    ImageButton androidImageButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidImageButton = findViewById(R.id.block55);
        androidImageButton1 = findViewById(R.id.block57);
        androidImageButton2 = findViewById(R.id.block59);

        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Washer.class));
            }
        });

        androidImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Washer.class));
            }
        });

        androidImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Washer.class));
            }
        });
    }
}
