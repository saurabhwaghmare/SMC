package com.example.saurabh.smc.fragements;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.saurabh.smc.ListModels.MemberModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.MemberCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class MemberFragment  extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    View view;
    int[] menutitles1;
    //TypedArray menuIcons;

    MemberCustomAdapter adapter;
    private List<MemberModel> MemberModels;

    public MemberFragment(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.list_with_fab, null, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewMember fragment= new CreateNewMember();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment,null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Members");



        menutitles = getResources().getStringArray(R.array.titles);
        menutitles1 = getResources().getIntArray(R.array.titles1);
        // menuIcons = getResources().obtainTypedArray(R.array.icons);

        MemberModels = new ArrayList<MemberModel>();


        for (int i = 0; i < menutitles.length; i++) {
            // MemberModel items = new MemberModel(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            MemberModel items = new MemberModel(menutitles[i],menutitles[i],Integer.toString(i));

            MemberModels.add(items);
        }

        adapter = new MemberCustomAdapter(getActivity(), MemberModels);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
                .show();

    }
}

