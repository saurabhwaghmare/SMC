package com.example.saurabh.smc.ListModels;

/**
 * Created by Saurabh on 5/26/2016.
 */
public class RowItem {


    private String title;
    private String address;


    public RowItem(String title, String address) {
        this.title = title;
        this.address = address;


    }

    public String getTitle() {
        return title;
    }
    public String getAddress() {
        return address;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
