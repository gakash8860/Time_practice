package com.example.time_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText date,time;
    Button b1,b2;
    int month,year,day,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date=findViewById(R.id.date1);
        time=findViewById(R.id.time);
        b1=findViewById(R.id.timebtn);
        b2=findViewById(R.id.datebtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            getTime();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getDate();
            }
        });
    }
    public void getDate(){
        final Calendar c = Calendar.getInstance();
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        day=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    date.setText(dayOfMonth+"-"+(month+1)+"-"+year);
            }
        },year,month,day);
        dialog.show();
    }
    public void getTime(){
        final Calendar c2 = Calendar.getInstance();
        hour=c2.get(Calendar.HOUR_OF_DAY);
        min=c2.get(Calendar.MINUTE);
        TimePickerDialog dialog2 = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(hourOfDay+" "+minute);
            }
        },hour,min,false);
        dialog2.show();
    }
}