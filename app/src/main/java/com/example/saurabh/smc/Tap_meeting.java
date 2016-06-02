package com.example.saurabh.smc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tap_meeting extends Fragment {

    private View view;

    public Tap_meeting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view  = inflater.inflate(R.layout.fragment_tap_meeting, container, false);
        view.findViewById(R.id.tap_on_meeting_edit_meeting_button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent openH = new Intent(getActivity(),Edit_Meeting.class);
                startActivity(openH);
            }
        });
        return view;
    }

}
