package com.example.saurabh.smc.ListModels;
//<!--android:textAppearance="?android:attr/textAppearanceLarge"-->
/**
 * Created by Saurabh on 5/26/2016.
 */
public class Meeting_Items {

    private String meeting_number;
    private String agenda;
    private String meeting_date;
    private String meeting_month;
    private String meeting_year;


    public Meeting_Items(String meeting_number, String agenda, String meeting_date,String meeting_month) {
        this.meeting_number = meeting_number;
        this.agenda = agenda;
        this.meeting_date = meeting_date;
        this.meeting_month = meeting_month;
    }

    public String getMeeting_number() {
        return meeting_number;
    }
    public String getAgenda() {
        return agenda;
    }
    public String getMeetingDate() { return meeting_date;}
    public String getMeetingMonth() {
        return meeting_month;
    }
    public String getMeetingYear() {
        return meeting_year;
    }

    public void setMeeting_number(String meeting_number) {
        this.meeting_number = meeting_number;
    }
    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }
    public void setMeetingDate(String meeting_date) {
        this.meeting_date = meeting_date;
    }
    public void setMeetingMonth(String meeting_month) { this.meeting_month = meeting_month;}
    public void setMeetingYear(String meeting_year) {
        this.meeting_year = meeting_year;
    }


}
