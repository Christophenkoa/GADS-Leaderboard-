package com.example.gadsleaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.models.LearnerScoreIQ;
import com.example.gadsleaderboard.services.ScoreIQService;
import com.example.gadsleaderboard.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill_fragment, container, false);

        final RecyclerView recyclerScoreIQ = (RecyclerView) view.findViewById(R.id.skillRecycleView);
        final LinearLayoutManager scoreIQLayoutManager = new LinearLayoutManager(getActivity());
        recyclerScoreIQ.setLayoutManager(scoreIQLayoutManager);

        ScoreIQService scoreIQService = ServiceBuilder.buildService(ScoreIQService.class);
        Call<List<LearnerScoreIQ>> call = scoreIQService.getLearners();

        call.enqueue(new Callback<List<LearnerScoreIQ>>() {
            @Override
            public void onResponse(Call<List<LearnerScoreIQ>> call, Response<List<LearnerScoreIQ>> response) {

                if(!response.isSuccessful()) {
                    Toast.makeText(getContext(), response.code() + " error",
                            Toast.LENGTH_SHORT).show();
                }
                //sort responseBody
                final SkillRecycleAdapter skillRecycleAdapter = new SkillRecycleAdapter(getContext(),
                        response.body());
                recyclerScoreIQ.setAdapter(skillRecycleAdapter);
            }

            @Override
            public void onFailure(Call<List<LearnerScoreIQ>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to load high learner score IQ.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
