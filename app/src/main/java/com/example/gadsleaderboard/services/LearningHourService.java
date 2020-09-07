package com.example.gadsleaderboard.services;

import com.example.gadsleaderboard.models.LearnerHours;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningHourService {
    @GET("/api/hours")
    Call<List<LearnerHours>> getLearners();
}