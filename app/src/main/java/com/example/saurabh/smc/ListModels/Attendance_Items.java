package com.example.saurabh.smc.ListModels;

import android.widget.CheckBox;

/**
 * Created by user on 6/1/2016.
 */
public class Attendance_Items {
    private String name_of_person;
    private String designation_of_person;
    private String mobile_number;
    private CheckBox attendance_checkBox;

    public Attendance_Items(String name_of_person, String designation_of_person, String mobile_number) {
        this.name_of_person = name_of_person;
        this.designation_of_person = designation_of_person;
        this.mobile_number = mobile_number;
    }

    public String getName_of_person() {
        return name_of_person;
    }
    public String getDesignation_of_person() {
        return designation_of_person;
    }
    public String getMobile_number() { return mobile_number;}


    public void setName_of_person(String name_of_person) {
        this.name_of_person = name_of_person;
    }
    public void setDesignation_of_person(String designation_of_person) {
        this.designation_of_person = designation_of_person;
    }
    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }



}
