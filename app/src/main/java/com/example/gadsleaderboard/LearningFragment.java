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

import com.example.gadsleaderboard.models.LearnerHours;
import com.example.gadsleaderboard.services.LearningHourService;
import com.example.gadsleaderboard.services.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.gadsleaderboard.SortArrayListByHours.sortByHours;

public class LearningFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.learning_fragment, container, false);

        final RecyclerView recyclerLearningHours = (RecyclerView) view.findViewById(R.id.learningRecyclerView);
        final LinearLayoutManager learningHoursLayoutManager = new LinearLayoutManager(getActivity());
        recyclerLearningHours.setLayoutManager(learningHoursLayoutManager);

        LearningHourService learningHourService = ServiceBuilder.buildService(LearningHourService.class);
        Call<List<LearnerHours>> call = learningHourService.getLearners();

        call.enqueue(new Callback<List<LearnerHours>>() {
            @Override
            public void onResponse(Call<List<LearnerHours>> call, Response<List<LearnerHours>> response) {

                if(!response.isSuccessful()) {
                    Toast.makeText(getContext(), response.code() + " error",
                            Toast.LENGTH_SHORT).show();
                }

                //sort responseBody
                final LearningRecycleAdapter learningRecycleAdapter = new LearningRecycleAdapter(getContext(),
                        response.body());
                recyclerLearningHours.setAdapter(learningRecycleAdapter);
            }

            @Override
            public void onFailure(Call<List<LearnerHours>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to load high learner hours.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}