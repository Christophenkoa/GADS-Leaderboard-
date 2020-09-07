package com.example.gadsleaderboard.models;

public class LearnerHours {
    private String name;
    private String hours;
    private String country;
    private String badgeUrl;

    public LearnerHours() {
        this.hours = "0";
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }


}