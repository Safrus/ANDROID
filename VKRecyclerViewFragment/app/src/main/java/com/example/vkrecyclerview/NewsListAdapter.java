package com.example.vkrecyclerview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<News> newsList;
    @Nullable
    private ItemClickListener listener;

    public NewsListAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public NewsListAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        final News news = newsList.get(position);

        Glide.with(holder.accountPhotoUrl.getContext())
                .load(news.getAccountPhotoUrl())
                .into(holder.accountPhotoUrl);
        holder.accountName.setText(news.getAccountName());
        holder.date.setText(news.getDate());
        holder.newsText.setText(news.getNewsText());
        Glide.with(holder.postPhotoUrl.getContext())
                .load(news.getPostPhotoUrl())
                .into(holder.postPhotoUrl);

        if(news.getLiked()==1){
            Glide.with(holder.likesUrl.getContext())
                    .load(R.drawable.likebluemin)
                    .into(holder.likesUrl);
            holder.likesCount.setTextColor(Color.parseColor("#006ba8"));
        }else{
            Glide.with(holder.likesUrl.getContext())
                    .load(R.drawable.likemin)
                    .into(holder.likesUrl);
            holder.likesCount.setTextColor(Color.parseColor("#979899"));
        }
        holder.likesCount.setText(Integer.toString(news.getLikesCount()));
        Glide.with(holder.commentsUrl.getContext())
                .load(news.getCommentsUrl())
                .into(holder.commentsUrl);
        holder.commentsCount.setText(String.valueOf(news.getCommentsCount()));
        Glide.with(holder.postsUrl.getContext())
                .load(news.getPostsUrl())
                .into(holder.postsUrl);
        holder.postsCount.setText(String.valueOf(news.getPostsCount()));
        Glide.with(holder.viewersUrl.getContext())
                .load(news.getViewersUrl())
                .into(holder.viewersUrl);
        holder.viewersCount.setText(String.valueOf(news.getViewersCount()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.itemClick(position,news);
                }
            }
        });

       holder.likesUrl.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(listener!=null){
                   if(news.getLiked()==1){
                       if(SecondFragment.favoriteItems.contains(news)){
                       SecondFragment.favoriteItems.remove(news);
                       }
                       news.setLiked(0);
                       news.setLikesCount(news.getLikesCount()-1);

                       Glide.with(holder.likesUrl.getContext())
                               .load(R.drawable.likemin)
                               .into(holder.likesUrl);
                       holder.likesCount.setText(Integer.toString(news.getLikesCount()));
                       holder.likesCount.setTextColor(Color.parseColor("#979899"));
                       Toast toast=Toast.makeText(v.getContext(),
                               "Like removed!",
                               Toast.LENGTH_SHORT);
                       toast.setGravity(Gravity.CENTER,0,0);
                       toast.show();
                   }else{
                       news.setLiked(1);
                       news.setLikesCount(news.getLikesCount()+1);

                       Glide.with(holder.likesUrl.getContext())
                               .load(R.drawable.likebluemin)
                               .into(holder.likesUrl);
                       holder.likesCount.setText(Integer.toString(news.getLikesCount()));
                       holder.likesCount.setTextColor(Color.parseColor("#006ba8"));
                       if(!SecondFragment.favoriteItems.contains(news)){
                           SecondFragment.favoriteItems.add(news);
                       }
                       Toast toast=Toast.makeText(v.getContext(),
                               "Liked!",
                               Toast.LENGTH_SHORT);
                       toast.setGravity(Gravity.CENTER,0,0);
                       toast.show();
                   }
               }
           }
       });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView accountPhotoUrl;
        TextView accountName;
        TextView date;
        TextView newsText;
        ImageView postPhotoUrl;
        ImageView likesUrl;
        TextView likesCount;
        ImageView commentsUrl;
        TextView commentsCount;
        ImageView postsUrl;
        TextView postsCount;
        ImageView viewersUrl;
        TextView viewersCount;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            accountPhotoUrl = itemView.findViewById(R.id.accountPhotoUrl);
            accountName = itemView.findViewById(R.id.accountName);
            date = itemView.findViewById(R.id.date);
            newsText = itemView.findViewById(R.id.newsText);
            postPhotoUrl = itemView.findViewById(R.id.postPhotoUrl);
            likesUrl = itemView.findViewById(R.id.likesUrl);
            likesCount = itemView.findViewById(R.id.likesCount);
            commentsUrl = itemView.findViewById(R.id.commentsUrl);
            commentsCount = itemView.findViewById(R.id.commentsCount);
            postsUrl = itemView.findViewById(R.id.postsUrl);
            postsCount = itemView.findViewById(R.id.postsCount);
            viewersUrl = itemView.findViewById(R.id.viewersUrl);
            viewersCount = itemView.findViewById(R.id.viewersCount);
        }
    }

    interface ItemClickListener {
        void itemClick(int position, News item);
    }
}