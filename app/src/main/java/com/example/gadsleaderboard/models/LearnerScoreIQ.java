package com.example.gadsleaderboard.models;

public class LearnerScoreIQ {
    private String name;
    private String score;
    private String country;
    private String badgeUrl;

    public LearnerScoreIQ() {
        this.score = "0";
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
