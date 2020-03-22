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

public class FavouriteNewsListAdapter extends RecyclerView.Adapter<FavouriteNewsListAdapter.FavouriteNewsViewHolder> {

    private List<News> favouriteNewsList;
    @Nullable
    private ItemClickListener listener;

    public FavouriteNewsListAdapter(List<News> newsList) {
        this.favouriteNewsList = newsList;
    }

    public FavouriteNewsListAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.favouriteNewsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavouriteNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new FavouriteNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavouriteNewsViewHolder holder, final int position) {
        final News news = favouriteNewsList.get(position);

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
                            SecondFragment.favoriteItems.remove(news);
                        for (News item : DataBase.news){
                            if(item.equals(news)){
                                item.setLiked(0);
                                item.setLikesCount(item.getLikesCount()-1);
                            }
                        }
                        notifyDataSetChanged();
                        Toast toast=Toast.makeText(v.getContext(),
                                "Like removed!",
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
        return favouriteNewsList.size();
    }

    public class FavouriteNewsViewHolder extends RecyclerView.ViewHolder {

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


        public FavouriteNewsViewHolder(@NonNull View itemView) {
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