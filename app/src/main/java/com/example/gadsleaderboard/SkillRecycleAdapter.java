package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.models.LearnerScoreIQ;

import java.util.List;

public class SkillRecycleAdapter extends RecyclerView.Adapter<SkillRecycleAdapter.ViewHolder> {

    private final Context mContext;
    private final List<LearnerScoreIQ> mLearner;
    private final LayoutInflater mLayoutInflater;

    public SkillRecycleAdapter(Context context, List<LearnerScoreIQ> learner) {
        mContext = context;
        this.mLearner = learner;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public SkillRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.skill_list_item,parent,false);
        return new SkillRecycleAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillRecycleAdapter.ViewHolder holder, int position) {
        holder.mLearnerName.setText(mLearner.get(position).getName());
        holder.mLearnerScore.setText(mLearner.get(position).getScore()+" score iq, "
                +mLearner.get(position).getCountry());
        holder.mImageView.setImageResource(R.drawable.skill_iq_trimmed);
    }

    @Override
    public int getItemCount() {
        return mLearner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLearnerName;
        public final TextView mLearnerScore;
        private final ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLearnerName = itemView.findViewById(R.id.learner_name_iq);
            mLearnerScore = itemView.findViewById(R.id.learner_iq_score);
            mImageView = itemView.findViewById(R.id.skill_iq_badge);
        }
    }
}
