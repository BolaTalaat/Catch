package com.example.corsatk;

/**
 * Created by bola on 5/25/2017.
 */

public class Item {
    private int imgResId;
    private String title;
    private String jobs;
    private String phoneNumer;

    public Item(int imgResId, String title, String jobs ,String phoneNumer) {
        this.imgResId = imgResId;
        this.title = title;
        this.jobs = jobs;
        this.phoneNumer = phoneNumer;
    }



    public int getImgResId() {
        return imgResId;
    }

    public String getTitle() {
        return title;
    }

    public String getjobs() {
        return jobs;
    }

     public String getPhoneNumer() {
     return phoneNumer;
}
}
