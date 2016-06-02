package com.example.saurabh.smc;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Create_Meeting extends AppCompatActivity {

//    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
//    private TextView dateView1;
    private TextView timeView;
    private int year, month, day, minute, hour;
//    public static Button newdate;
//    boolean buttonpress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__meeting);

//        dateView = (Button) findViewById(R.id.button1);
//        dateView1 = (Button) findViewById(R.id.pick_date);
        dateView = (TextView) findViewById(R.id.create_meeting_date_set);
        timeView = (TextView) findViewById(R.id.create_meeting_time_set);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        minute = calendar.get(Calendar.MINUTE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
//        hour = calendar.get(Calendar.AM_PM);
        showDate(year, month + 1, day);
        showTime(hour, minute);

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
        //.show();
    }
    @SuppressWarnings("deprecation")
    public void setTime(View view) {
        showDialog(0);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        else if (id == 0) {
            return new TimePickerDialog(this, myTimeListener, hour, minute, true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
        //        @Override
//        public void onTimeSet(TimePicker ar0, int ar1, int ar2){
//            showTime(ar1,ar2);
//        }
        public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
            showTime(arg1, arg2);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
//        dateView1.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }

    private void showTime(int hour, int minute) {
        String aMpM = "AM";
        if (hour > 11) {
            aMpM = "PM";
        }
        if (hour > 12) {
            hour = hour - 12;
        }
        if (hour >= 0 && hour < 10) {
            if (minute >= 0 && minute < 10) {
                timeView.setText(new StringBuilder().append("0").append(hour).append(":")
                        .append("0").append(minute).append(" ").append(aMpM));
            } else {
                timeView.setText(new StringBuilder().append("0").append(hour).append(":")
                        .append(minute).append(" ").append(aMpM));
            }
        } else {
            if (minute >= 0 && minute < 10) {
                timeView.setText(new StringBuilder().append(hour).append(":")
                        .append("0").append(minute).append(" ").append(aMpM));
            } else {
                timeView.setText(new StringBuilder().append(hour).append(":")
                        .append(minute).append(" ").append(aMpM));
            }
        }
    }
}
