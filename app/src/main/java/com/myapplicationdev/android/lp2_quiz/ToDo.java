package com.myapplicationdev.android.lp2_quiz;

public class ToDo {
    private int id;
    private String date;
    private int data;

    public ToDo(int id, String date, int data) {
        this.id = id;
        this.date = date;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getData() {
        return data;
    }
}
