package com.epicodus.groupfund.models;

/**
 * Created by DJRoy on 7/12/16.
 */
public class Event {
    private String title;
    private String startDate;
    private String endDate;
    private String location;
    private String description;
    private String totcalCost;
//    private String pushId;

    public Event() {}

    public Event(String title, String startDate, String endDate, String location, String description, String totalCost) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.totcalCost = totalCost;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getTotcalCost() {
        return totcalCost;
    }

//    public String getPushId() {
//        return pushId;
//    }
//
//    public void setPushId(String mPushId) {
//        this.pushId = mPushId;
//    }

}