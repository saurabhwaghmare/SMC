package com.example.saurabh.smc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.saurabh.smc.ListModels.Meeting_Items;
import com.example.saurabh.smc.adapter.MeetingAdapter;

import java.util.ArrayList;
import java.util.List;


public class meeting extends ListFragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
    String[] meeting_number_titles;
    String[] agendas;
    String[] meeting_dates;
    String[] meeting_months;
    private View view;
//    String[] meeting_years;
    //TypedArray menuIcons;

    MeetingAdapter adapter;;
    private List<Meeting_Items> meetingItemses;
//    private List<RowItem> rowItems1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view  = inflater.inflate(R.layout.meeting_list, container, false);
        view.findViewById(R.id.meeting_list_fab).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent openH = new Intent(getActivity(),Create_Meeting.class);
                startActivity(openH);
            }
        });
        return view;
//        return inflater.inflate(R.layout.meeting_list, null, false);
    }

//    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.meeting_list_fabfab);
//    fab.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();
//        }
//    });

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        meeting_number_titles = getResources().getStringArray(R.array.meeting_number);
        agendas = getResources().getStringArray(R.array.agendas);
        meeting_dates = getResources().getStringArray(R.array.meeting_dates);
        meeting_months = getResources().getStringArray(R.array.meeting_months);
//        meeting_years = getResources().getStringArray(R.array.meeting_years);
        // menuIcons = getResources().obtainTypedArray(R.array.icons);

        meetingItemses = new ArrayList<Meeting_Items>();
//        rowItems1 = new ArrayList<RowItem>();

        for (int i = 0; i < meeting_number_titles.length; i++) {
            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            Meeting_Items items = new Meeting_Items(meeting_number_titles[i], agendas[i],meeting_dates[i],meeting_months[i]);

            meetingItemses.add(items);
        }
//        for (int i = 0; i < address.length; i++) {
//            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
//            //  i, -1));
//            RowItem items1 = new RowItem(address[i]);
//
//            rowItems1.add(items1);
//        }

        adapter = new MeetingAdapter(getActivity(), meetingItemses);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position,
        long id){

            Tap_meeting fragment = new Tap_meeting();
            getFragmentManager().beginTransaction().replace(R.id.frame_container,fragment,null)
                    .addToBackStack(null)
                    .commit();

        }
    }
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public meeting() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment meeting.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static meeting newInstance(String param1, String param2) {
//        meeting fragment = new meeting();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_meeting, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

