package com.example.cs2pj20springcoursework;

public class EventCell {

    private String moduleName;
    private String roomName;
    private String date;
    private String startTime;
    private String endTime;

    public EventCell(String moduleName, String roomName, String date, String startTime, String endTime){
        this.moduleName = moduleName;
        this.roomName = roomName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getModuleName(){
        return this.moduleName;
    }

    public String getRoomName(){
        return this.roomName;
    }

    public String getDate(){
        return this.date;
    }

    public String getStartTime(){
        return this.startTime;
    }

    public String getEndTime(){
        return this.endTime;
    }

    public void setModuleName(String moduleName){
        this.moduleName = moduleName;
    }

    public void setLectureName(String roomName){
        this.roomName = roomName;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
}
