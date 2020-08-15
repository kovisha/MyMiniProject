package com.example.myminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class AddPeriodActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;

    public String EXTRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_period);

        Intent myIntent = getIntent();

        tvw = (TextView) findViewById(R.id.textView1);
        eText = (EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(AddPeriodActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnGet = (Button) findViewById(R.id.button2);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Start Date: " + eText.getText());
            }
        });

    }

    public void tick(View view) {

        Intent secondIntent = new Intent(AddPeriodActivity.this, DisplayStartDateHome.class);
        EditText editText = findViewById(R.id.editText1);

        EXTRA = editText.getText().toString();

        secondIntent.putExtra("MAIN_EXTRA", EXTRA);
        startActivity(secondIntent);

    }
}