package com.example.saurabh.smc;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.saurabh.smc.ListModels.ActionModel;
import com.example.saurabh.smc.adapter.ActionCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class ActionFragment  extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    //TypedArray menuIcons;

    ActionCustomAdapter adapter;
    private List<ActionModel> ActionModels;

    public ActionFragment(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Actions");

        menutitles = getResources().getStringArray(R.array.titles);
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

        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
                .show();

    }
}
