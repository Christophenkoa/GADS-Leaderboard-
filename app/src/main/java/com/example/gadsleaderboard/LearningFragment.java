package com.example.gadsleaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LearningFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.learning_fragment, container, false);

        final RecyclerView recyclerLearningHours = (RecyclerView) view.findViewById(R.id.learningRecyclerView);
        final LinearLayoutManager learningHoursLayoutManager = new LinearLayoutManager(getActivity());
        recyclerLearningHours.setLayoutManager(learningHoursLayoutManager);

        String [] learner = {"toto", "titi", "titu", "Massayakop", "COCO", "MonMiel", "FIOnon",
        "Tapioca", "COOCOC", "1211", "223", "ZAER"};

        final LearningRecycleAdapter learningRecycleAdapter = new LearningRecycleAdapter(getContext(),learner);
        recyclerLearningHours.setAdapter(learningRecycleAdapter);

        return view;
    }
}
