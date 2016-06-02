package com.example.saurabh.smc.fragements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.ListModels.FaqModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.FAQCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQ extends Fragment {

    View view;

    public FAQ() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.recycleview_layout, container, false);


        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        List<FaqModel> qa;

        // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.

        qa = new ArrayList<>();
        qa.add(new FaqModel("Signgle line quetions", "Signle line answer"));
        qa.add(new FaqModel("How many lines can a qutions may have?", "It can have any number of lines like 2 line to 10 lines"));
        qa.add(new FaqModel("How may lines does answer have and is view compatible with it?", "Answer alos can be many liner and view is compatible with it."));


        FAQCustomAdapter adapter = new FAQCustomAdapter(qa);
        rv.setAdapter(adapter);

    return view;

    }
}
