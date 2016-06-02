package com.example.saurabh.smc.fragements;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.saurabh.smc.JobDescriptionAc;
import com.example.saurabh.smc.ListModels.ActionModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.ActionCustomAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Jobs  extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    View view;
    //TypedArray menuIcons;

    ActionCustomAdapter adapter;
    private List<ActionModel> ActionModels;

    public Jobs(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.list_fragment, null, false);

//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NewActionFragment fragment= new NewActionFragment();
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.frame_container, fragment,null)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Jobs");

        menutitles = getResources().getStringArray(R.array.mem_type);
        // menuIcons = getResources().obtainTypedArray(R.array.icons);

        ActionModels = new ArrayList<ActionModel>();


        for (int i = 0; i < menutitles.length; i++) {
            // ActionModel items = new ActionModel(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            ActionModel items = new ActionModel(menutitles[i],menutitles[i],menutitles[i],menutitles[i],false);

            ActionModels.add(items);
        }

        adapter = new ActionCustomAdapter(getActivity(), ActionModels);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

//        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
//                .show();

        Intent openH = new Intent(getContext(), JobDescriptionAc.class);
        startActivity(openH);

    }
}
