package com.app.engineerai_exam.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.engineerai_exam.R;
import com.app.engineerai_exam.model.HitsItem;
import com.app.engineerai_exam.utility.Utility;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<HitsItem> hitList;
    private OnItemClickListener onItemClickListener;

    public PostAdapter(List<HitsItem> hitList, OnItemClickListener onItemClickListener) {
        this.hitList = hitList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, final int position) {
        final HitsItem hit = hitList.get(position);
        holder.txtPostTitle.setText(hit.getTitle());
        holder.txtPostCreatedAt.setText(hit.getCreatedAt());
        holder.switchPost.setChecked(hit.getChecked());
    }

    @Override
    public int getItemCount() {
        if (hitList != null && hitList.size() > 0) {
            return hitList.size();
        }
        return 0;
    }

    public void setItem(List<HitsItem> hitList) {
        this.hitList = hitList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(List<HitsItem> item);
    }

    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtPostTitle;
        private TextView txtPostCreatedAt;
        private Switch switchPost;

        PostViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPostTitle = itemView.findViewById(R.id.txtPostTitle);
            txtPostCreatedAt = itemView.findViewById(R.id.txtPostCreatedAt);
            switchPost = itemView.findViewById(R.id.switchPost);

            switchPost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switchPost.setChecked(isChecked);
                    hitList.get(getAdapterPosition()).setChecked(isChecked);
                    onItemClickListener.onItemClick(hitList);
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switchPost.setChecked(!switchPost.isChecked());
            hitList.get(getAdapterPosition()).setChecked(switchPost.isChecked());
            onItemClickListener.onItemClick(hitList);
        }
    }
}
