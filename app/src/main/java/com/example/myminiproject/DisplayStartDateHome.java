package com.example.myminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayStartDateHome extends AppCompatActivity {

    String takeExtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_start_date_home);

        Intent intent = getIntent();

        takeExtra = intent.getStringExtra("MAIN_EXTRA");

        TextView tv = findViewById(R.id.getStartDate);
        tv.setText(takeExtra);
    }
}