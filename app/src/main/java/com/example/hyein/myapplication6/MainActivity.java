package com.example.hyein.myapplication6;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    RadioButton day,time;
    RadioGroup rg;
    Button start,end1;
    CalendarView calendarView;
    TimePicker timePicker;
    Chronometer chro;
    String year,month,date,hour,min;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        end1 = (Button) findViewById(R.id.end1);
        rg = (RadioGroup) findViewById(R.id.rg);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        chro = (Chronometer) findViewById(R.id.chro);
        day = (RadioButton) findViewById(R.id.day);
        time = (RadioButton) findViewById(R.id.time);
        textView2 = (TextView) findViewById(R.id.textView2);

        day.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        time.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                chro.setBase(SystemClock.elapsedRealtime());
                chro.start();
                chro.setTextColor(Color.RED);
            }
        });


        end1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                chro.stop();
                chro.setTextColor(Color.BLUE);

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(calendarView.getDate());

                year = Integer.toString(curDate.get(Calendar.YEAR));
                month = Integer.toString(1 + curDate.get(Calendar.MONTH));
                date = Integer.toString(curDate.get(Calendar.DATE));

                hour = Integer.toString(timePicker.getCurrentHour());
                min = Integer.toString(timePicker.getCurrentMinute());

                textView2.setText(year + "/" + month + "/" + date + "/" + hour + ":" + min);
            }
        });


        }
}
