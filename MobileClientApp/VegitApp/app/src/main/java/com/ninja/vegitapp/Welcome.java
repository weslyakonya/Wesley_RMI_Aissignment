package com.ninja.vegitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    private Button addVeg, viewVeg, viewCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        addVeg = findViewById(R.id.addVeg);
        viewVeg = findViewById(R.id.viewVeg);
        viewCost = findViewById(R.id.viewCost);

        addVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(i);
            }
        });
        viewVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ViewVegs.class);
                startActivity(i);
            }
        });

        viewCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ViewCost.class);
                startActivity(i);
            }
        });


    }
}