package com.example.saurabh.smc.fragements;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class homepage_tabs extends Fragment {

    View view;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public homepage_tabs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_homepage_tabs, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();


       // activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Homepage");
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new Jobs(), "JOBS");
        adapter.addFragment(new WrapperFragment(), "FEEDS");
        adapter.addFragment(new WrapperFragment(), "DISCUSSIONS");

        viewPager.setAdapter(adapter);
    }

}
