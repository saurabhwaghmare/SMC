package com.example.saurabh.smc;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Edit_Meeting extends AppCompatActivity {

    //    private DatePicker datePicker;
    private Calendar edit_meeting_calendar;
    private TextView edit_meeting_dateView;
    //    private TextView dateView1;
    private TextView edit_meeting_timeView;
//    private Button attendance_button;
    private int edit_meeting_year, edit_meeting_month, edit_meeting_day, edit_meeting_minute, edit_meeting_hour;
//    public static Button newdate;
//    boolean buttonpress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__meeting);

       Button attendance_button = (Button) findViewById(R.id.edit_meeting_attendance_button);
        attendance_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Attendance fragment = new Attendance();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.attendance_container1,fragment);
                fragmentTransaction.commit();
            }
        });

        edit_meeting_dateView = (TextView) findViewById(R.id.edit_meeting_date_set);
        edit_meeting_timeView = (TextView) findViewById(R.id.edit_meeting_time_set);
        edit_meeting_calendar = Calendar.getInstance();
        edit_meeting_year = edit_meeting_calendar.get(Calendar.YEAR);
        edit_meeting_month = edit_meeting_calendar.get(Calendar.MONTH);
        edit_meeting_day = edit_meeting_calendar.get(Calendar.DAY_OF_MONTH);

        edit_meeting_minute = edit_meeting_calendar.get(Calendar.MINUTE);
        edit_meeting_hour = edit_meeting_calendar.get(Calendar.HOUR_OF_DAY);
//        edit_meeting_hour = edit_meeting_calendar.get(Calendar.AM_PM);
        showDate(edit_meeting_year, edit_meeting_month + 1, edit_meeting_day);
        showTime(edit_meeting_hour, edit_meeting_minute);
    }


    @SuppressWarnings("deprecation")
    public void edit_meeting_setDate(View view) {
        showDialog(100);
        //Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
        //.show();
    }
    @SuppressWarnings("deprecation")
    public void edit_meeting_setTime(View view) {
        showDialog(10);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 100) {
            return new DatePickerDialog(this, myDateListener,  edit_meeting_year,  edit_meeting_month,  edit_meeting_day);
        }
        else if (id == 10) {
            return new TimePickerDialog(this, myTimeListener,  edit_meeting_hour,  edit_meeting_minute, true);
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
        edit_meeting_dateView.setText(new StringBuilder().append(day).append("/")
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
                edit_meeting_timeView.setText(new StringBuilder().append("0").append(hour).append(":")
                        .append("0").append(minute).append(" ").append(aMpM));
            } else {
                edit_meeting_timeView.setText(new StringBuilder().append("0").append(hour).append(":")
                        .append(minute).append(" ").append(aMpM));
            }
        } else {
            if (minute >= 0 && minute < 10) {
                edit_meeting_timeView.setText(new StringBuilder().append(hour).append(":")
                        .append("0").append(minute).append(" ").append(aMpM));
            } else {
                edit_meeting_timeView.setText(new StringBuilder().append(hour).append(":")
                        .append(minute).append(" ").append(aMpM));
            }
        }
    }

}
