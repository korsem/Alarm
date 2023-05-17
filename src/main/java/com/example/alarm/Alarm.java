package com.example.alarm;

public class Alarm {
    private String alarmName;
    private int hour;
    private int minute;
    private double volume;
    private boolean weekly;

    public Alarm(String alarmName, int hour, int minute, double volume, boolean weekly) {
        this.alarmName = alarmName;
        this.hour = hour;
        this.minute = minute;
        this.volume = volume;
        this.weekly = weekly;
    }

    // Gettery i Settery

    public String getAlarmName() {
        return alarmName;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean getWeekly(){
        return weekly;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "alarmName='" + alarmName + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                ", volume=" + volume +
                ", weekly=" + weekly +
                '}';
    }
}