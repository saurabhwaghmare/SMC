package com.example.saurabh.smc;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.saurabh.smc.ListModels.RowItem;
import com.example.saurabh.smc.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 5/26/2016.
 */
public class MyListFragment  extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    //TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.titles);
       // menuIcons = getResources().obtainTypedArray(R.array.icons);

        rowItems = new ArrayList<RowItem>();

        for (int i = 0; i < menutitles.length; i++) {
           // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
                  //  i, -1));
            RowItem items = new RowItem(menutitles[i]);

            rowItems.add(items);
        }

        adapter = new CustomAdapter(getActivity(), rowItems);
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
