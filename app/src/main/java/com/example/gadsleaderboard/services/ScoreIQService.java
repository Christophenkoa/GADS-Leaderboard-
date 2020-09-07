package com.example.gadsleaderboard.services;

import com.example.gadsleaderboard.models.LearnerScoreIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScoreIQService {
    @GET("/api/skilliq")
    Call<List<LearnerScoreIQ>> getLearners();
}
