package com.example.saurabh.smc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.Attendance_Items;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by user on 6/1/2016.
 */
public class Attendance_Adapter extends BaseAdapter {
    Context context;
    Attendance_Items tempValues=null;
    public int num;
    //    RowItem tempValue1=null;
    List<Attendance_Items> attendanceItems;
//    List<RowItem> rowItem1;

    public Attendance_Adapter(Context context, List<Attendance_Items> attendanceItems) {
        this.context = context;
        this.attendanceItems = attendanceItems;
//        this.rowItem1 = rowItem1;

    }

    @Override
    public int getCount() {

        return attendanceItems.size();
    }

    @Override
    public Object getItem(int position) {

        return attendanceItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return attendanceItems.indexOf(getItem(position));
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder_attendance holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            vi = mInflater.inflate(R.layout.fragment_attendance, null);


            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder_attendance();
            holder.name_of_person = (TextView) vi.findViewById(R.id.attendance_name_of_person);
            holder.designation_of_person = (TextView) vi.findViewById(R.id.attendance_designation_of_person);
            holder.mobile_number = (TextView) vi.findViewById(R.id.attendance_mobile_number_of_person);
//            holder.meetingMonth = (TextView) vi.findViewById(R.id.meeting_month);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder_attendance) vi.getTag();

        if(attendanceItems.size()<=0)
        {
            holder.name_of_person.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = (Attendance_Items) attendanceItems.get( position );
//            tempValue1 = null;
//            tempValue1 = ( RowItem ) rowItem1.get(position);


            /************  Set Model values in Holder elements ***********/
            if(holder.name_of_person!= null){
                holder.name_of_person.setText( tempValues.getName_of_person() );}

            holder.designation_of_person.setText(tempValues.getDesignation_of_person());

//                new StringBuilder().append(day).append("/")
//            if(tempValues.getMeetingDate().length() == 1){
//                String temp = "0" + tempValues.getMeetingDate();
//                holder.meetingDate.setText(temp);
//            }


                holder.mobile_number.setText(tempValues.getMobile_number());


//            holder.meetingMonth.setText(tempValues.getMeetingMonth());


        }
        return vi;



    }
}

class ViewHolder_attendance{

    public TextView name_of_person;
    public TextView designation_of_person;
    public TextView mobile_number;
//    public TextView meetingMonth;
    //    public TextView meetingYear;
    public ImageView image;

}

