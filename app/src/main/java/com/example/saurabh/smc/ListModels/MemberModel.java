package com.example.saurabh.smc.ListModels;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class MemberModel {


    private String name;
    private String desig;
    private String num ;



    public MemberModel(String name,String desig, String num) {
        this.name = name;
        this.desig = desig;
        this.num = num;



    }

    public String getName() {
        return name;
    }

    public void setname(String title) {
        this.name = title;
    }
    public String getdesig() {
        return desig;
    }

    public void setdesig(String date) {
        this.desig = date;
    }
    public String getNum() {
        return num;
    }

    public void setNUm(String title) {
        this.num = title;
    }

}
