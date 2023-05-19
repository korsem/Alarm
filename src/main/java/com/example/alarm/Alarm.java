package com.example.alarm;

public class Alarm {
    private String alarmName;
    private int hour;
    private int minute;
    private double volume;
    private boolean weekly;
    private boolean[] weekDays = new boolean[7];

    public Alarm(String alarmName, int hour, int minute, double volume, boolean weekly, boolean[] weekDays) {
        this.alarmName = alarmName;
        this.hour = hour;
        this.minute = minute;
        this.volume = volume;
        this.weekly = weekly;
        this.weekDays = weekDays;
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
                ", weekdays=" + weekDaysToString() +
                '}';
    }
    public String weekDaysToString() {
        String numbers = "";
        for (int i = 0; i < 7; i++) {
            if (weekDays[i]) {
                numbers += i + " ";
            }
        }
        return numbers;
    }
}