package com.example.vkrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.view.View.NO_ID;

public class NewsDetailActivity extends AppCompatActivity {

    ImageView accountPhotoUrl;
    TextView accountName;
    TextView date;
    TextView newsText;
    ImageView postPhotoUrl;
    ImageView likesUrl;
    TextView likes;
    ImageView userLike1;
    ImageView userLike2;
    TextView likesDetail;
    TextView showCom;//private String showCom;
    ImageView userComUrl1;//private int userComUrl1;
    TextView userComAcc1;//private String userComAcc1;
    TextView userComText1;//private String userComText1;
    TextView userComDate1;//private String userComDate1;
    ImageView userComReplyUrl1;//private int userComReplyUrl1;
    ImageView userComLikeUrl1;//private int userComLikeUrl1;
    TextView userComLike1;//private int userComLike1;
    ImageView postsUrl;
    TextView postsCount;
    ImageView viewersUrl;
    TextView viewersCount;
    private int isLiked;
    private int likesCount;



    public void onBackPressed() {
        Intent intent = new Intent(NewsDetailActivity.this, MainActivity.class);
        intent.putExtra("pagerState", 1);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(0, 0);

    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_detail);
        accountPhotoUrl = findViewById(R.id.accountPhotoUrl);
        accountName = findViewById(R.id.accountName);
        date = findViewById(R.id.date);
        newsText = findViewById(R.id.newsText);
        postPhotoUrl = findViewById(R.id.postPhotoUrl);
        likesUrl = findViewById(R.id.likesUrl);
        likes = findViewById(R.id.likesCount);
        userLike1=findViewById(R.id.userLike1);
        userLike2=findViewById(R.id.userLike2);
        likesDetail=findViewById(R.id.likesDetail);
        showCom=findViewById(R.id.showCom);//private String showCom;
        userComUrl1=findViewById(R.id.userComUrl1);//private int userComUrl1;
        userComAcc1=findViewById(R.id.userComAcc1);//private String userComAcc1;
        userComText1=findViewById(R.id.userComText1);//private String userComText1;
        userComDate1=findViewById(R.id.userComDate1);//private String userComDate1;
        userComReplyUrl1=findViewById(R.id.userComReplyUrl1);//private int userComReplyUrl1;
        userComLikeUrl1=findViewById(R.id.userComLikeUrl1);//private int userComLikeUrl1;
        userComLike1=findViewById(R.id.userComLike1);//private int userComLike1;
        postsUrl = findViewById(R.id.postsUrl);
        postsCount = findViewById(R.id.postsCount);
        viewersUrl = findViewById(R.id.viewersUrl);
        viewersCount = findViewById(R.id.viewersCount);

        final News news = (News) getIntent().getParcelableExtra("news");

        likesCount = news.getLikesCount();

        if(news.getLiked()==1){
            Glide.with(likesUrl.getContext())
                    .load(R.drawable.likeblue)
                    .into(likesUrl);
            likes.setTextColor(Color.parseColor("#006ba8"));
        }
        else{
            Glide.with(likesUrl.getContext())
                    .load(R.drawable.likemin)
                    .into(likesUrl);
            likes.setTextColor(Color.parseColor("#979899"));
        }


        Glide.with(accountPhotoUrl.getContext())
                .load(news.getAccountPhotoUrl())
                .into(accountPhotoUrl);

        accountName.setText(news.getAccountName());

        date.setText(news.getDate());

        newsText.setText(news.getNewsText());

        Glide.with(postPhotoUrl.getContext())
                .load(news.getPostPhotoUrl())
                .into(postPhotoUrl);

        likes.setText(Integer.toString(news.getLikesCount()));

        Glide.with(userLike1.getContext())
                .load(news.getUserLike1())
                .into(userLike1);

        Glide.with(userLike2.getContext())
                .load(news.getUserLike2())
                .into(userLike2);

        likesDetail.setText(news.getLikesDetail());

        showCom.setText(news.getShowCom());

        Glide.with(userComUrl1.getContext())
                .load(news.getUserComUrl1())
                .into(userComUrl1);

        userComAcc1.setText(news.getUserComAcc1());

        userComText1.setText(news.getUserComText1());

        userComDate1.setText(news.getUserComDate1());

        Glide.with(userComReplyUrl1.getContext())
                .load(news.getUserComReplyUrl1())
                .into(userComReplyUrl1);

        Glide.with(userComLikeUrl1.getContext())
                .load(news.getUserComLikeUrl1())
                .into(userComLikeUrl1);

        userComLike1.setText(Integer.toString(news.getUserComLike1()));

        Glide.with(postsUrl.getContext())
                .load(news.getPostsUrl())
                .into(postsUrl);

        Glide.with(postsUrl.getContext())
                .load(news.getPostsUrl())
                .into(postsUrl);

        postsCount.setText(String.valueOf(news.getPostsCount()));

        Glide.with(viewersUrl.getContext())
                .load(news.getViewersUrl())
                .into(viewersUrl);

        viewersCount.setText(String.valueOf(news.getViewersCount()));

        likesUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news.getLiked()==1){
                    if(SecondFragment.favoriteItems.contains(news)){
                        SecondFragment.favoriteItems.remove(news);
                    }
                    for(News item:DataBase.news){
                        if(item.equals(news)){
                            item.setLiked(0);
                            item.setLikesCount(item.getLikesCount()-1);
                        }
                    }
                    news.setLiked(0);
                    Glide.with(likesUrl.getContext())
                            .load(R.drawable.likemin)
                            .into(likesUrl);
                    news.setLikesCount(news.getLikesCount()-1);
                    likes.setText(Integer.toString(news.getLikesCount()));
                    likes.setTextColor(Color.parseColor("#979899"));
                    Toast toast = Toast.makeText(v.getContext(),
                            "Like removed!",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else{
                    for (News item:DataBase.news){
                        if(item.equals(news)){
                            item.setLiked(1);
                            item.setLikesCount(item.getLikesCount()+1);
                        }
                    }
                    news.setLiked(1);
                    Glide.with(likesUrl.getContext())
                            .load(R.drawable.likebluemin)
                            .into(likesUrl);

                    news.setLikesCount(news.getLikesCount()+1);

                    likes.setText(Integer.toString(news.getLikesCount()));
                    likes.setTextColor(Color.parseColor("#006ba8"));
                    if(!SecondFragment.favoriteItems.contains(news)) {
                        SecondFragment.favoriteItems.add(news);
                    }
                    Toast toast = Toast.makeText(v.getContext(),
                            "Liked!",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }

}
