package com.example.midexamproject.data;

public class ScheduleData {

    public String team1, team2, date, time, place;
    public Integer team1_img, team2_img;

    public ScheduleData(String team1, String team2, String date, String time, String place, Integer img1, Integer img2) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        this.place = place;
        this.team1_img = img1;
        this.team2_img = img2;
    }

}
