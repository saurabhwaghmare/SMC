package com.example.saurabh.smc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.saurabh.smc.ListModels.Attendance_Items;
import com.example.saurabh.smc.adapter.Attendance_Adapter;

import java.util.ArrayList;
import java.util.List;

;


/**
 * A simple {@link Fragment} subclass.
 */
public class Attendance extends ListFragment implements AdapterView.OnItemClickListener {

    String[] name_of_persons;
    String[] designation_of_persons;
    String[] mobile_numbers;
//    String[] meeting_months;
//    String[] meeting_years;
    //TypedArray menuIcons;

    Attendance_Adapter adapter;;
    private List<Attendance_Items> AttendanceItemses;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.attendance_list, null, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        name_of_persons = getResources().getStringArray(R.array.name_of_persons);
        designation_of_persons = getResources().getStringArray(R.array.designation_of_persons);
        mobile_numbers = getResources().getStringArray(R.array.mobile_numbers);
//        meeting_months = getResources().getStringArray(R.array.meeting_months);
//        meeting_years = getResources().getStringArray(R.array.meeting_years);
        // menuIcons = getResources().obtainTypedArray(R.array.icons);

        AttendanceItemses = new ArrayList<Attendance_Items>();
//        rowItems1 = new ArrayList<RowItem>();

        for (int i = 0; i < name_of_persons.length; i++) {
            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            Attendance_Items items = new Attendance_Items(name_of_persons[i], designation_of_persons[i],mobile_numbers[i]);

            AttendanceItemses.add(items);
        }

        adapter = new Attendance_Adapter(getActivity(), AttendanceItemses);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick (AdapterView < ? > parent, View view,int position,
                             long id){

        Toast.makeText(getActivity(), name_of_persons[position], Toast.LENGTH_SHORT)
                .show();

    }
}


