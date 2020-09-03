package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LearningRecycleAdapter extends RecyclerView.Adapter<LearningRecycleAdapter.ViewHolder> {

    private final Context mContext;
    private final String[] mLearner;
    private final LayoutInflater mLayoutInflater;

    public LearningRecycleAdapter(Context context, String[] learner) {
        mContext = context;
        this.mLearner = learner;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learning_list_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mLearnerName.setText(mLearner[position]);
        holder.mLearnerHours.setText(mLearner[position]);
        holder.mImageView.setImageResource(R.drawable.top_learner);
    }

    @Override
    public int getItemCount() {
        return mLearner.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLearnerName;
        public final TextView mLearnerHours;
        private final ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearnerName = itemView.findViewById(R.id.learner_name);
            mLearnerHours = itemView.findViewById(R.id.learner_hours);
            mImageView = itemView.findViewById(R.id.badge_hours);
        }
    }
}
