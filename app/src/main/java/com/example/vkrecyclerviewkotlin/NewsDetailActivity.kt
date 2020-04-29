package com.example.vkrecyclerviewkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var accountPhotoUrl: ImageView
    private lateinit var accountName: TextView
    private lateinit var date: TextView
    private lateinit var newsText: TextView
    private lateinit var postPhotoUrl: ImageView
    private lateinit var likesUrl: ImageView
    private lateinit var likes: TextView
    private lateinit var userLike1: ImageView
    private lateinit var userLike2: ImageView
    private lateinit var likesDetail: TextView
    private lateinit var showCom: TextView
    private lateinit var userComUrl1: ImageView
    private lateinit var userComAcc1: TextView
    private lateinit var userComText1: TextView
    private lateinit var userComDate1: TextView
    private lateinit var userComReplyUrl1: ImageView
    private lateinit var userComLikeUrl1: ImageView
    private lateinit var userComLike1: TextView
    private lateinit var postsUrl: ImageView
    private lateinit var postsCount: TextView
    private lateinit var viewersUrl: ImageView
    private lateinit var viewersCount: TextView
    private var likesCount = 0
    private lateinit var thisNews: News

    override fun onBackPressed() {
        DataBase.news[thisNews.id] = thisNews
        val intent = Intent(this@NewsDetailActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        accountPhotoUrl = findViewById(R.id.accountPhotoUrl)
        accountName = findViewById(R.id.accountName)
        date = findViewById(R.id.date)
        newsText = findViewById(R.id.newsText)
        postPhotoUrl = findViewById(R.id.postPhotoUrl)
        likesUrl = findViewById(R.id.likesUrl)
        likes = findViewById(R.id.likesCount)
        userLike1 = findViewById(R.id.userLike1)
        userLike2 = findViewById(R.id.userLike2)
        likesDetail = findViewById(R.id.likesDetail)
        showCom = findViewById(R.id.showCom) //private String showCom;
        userComUrl1 =
            findViewById(R.id.userComUrl1) //private int userComUrl1;
        userComAcc1 = findViewById(R.id.userComAcc1) //private String userComAcc1;
        userComText1 = findViewById(R.id.userComText1) //private String userComText1;
        userComDate1 = findViewById(R.id.userComDate1) //private String userComDate1;
        userComReplyUrl1 =
            findViewById(R.id.userComReplyUrl1) //private int userComReplyUrl1;
        userComLikeUrl1 =
            findViewById(R.id.userComLikeUrl1) //private int userComLikeUrl1;
        userComLike1 = findViewById(R.id.userComLike1) //private int userComLike1;
        postsUrl = findViewById(R.id.postsUrl)
        postsCount = findViewById(R.id.postsCount)
        viewersUrl = findViewById(R.id.viewersUrl)
        viewersCount = findViewById(R.id.viewersCount)
        val news = intent.getParcelableExtra<Parcelable>("news") as News
        thisNews = news
        likesCount = news.likesCount
        if (news.liked == 1) {
            Glide.with(likesUrl.context)
                .load(R.drawable.likeblue)
                .into(likesUrl)
            likes.setTextColor(Color.parseColor("#006ba8"))
        } else {
            Glide.with(likesUrl.context)
                .load(R.drawable.likemin)
                .into(likesUrl)
            likes.setTextColor(Color.parseColor("#979899"))
        }
        Glide.with(accountPhotoUrl.context)
            .load(news.accountPhotoUrl)
            .into(accountPhotoUrl)
        accountName.text = news.accountName
        date.text = news.date
        newsText.text = news.newsText
        Glide.with(postPhotoUrl.context)
            .load(news.postPhotoUrl)
            .into(postPhotoUrl)
        likes.text = news.likesCount.toString()
        Glide.with(userLike1.context)
            .load(news.userLike1)
            .into(userLike1)
        Glide.with(userLike2.context)
            .load(news.userLike2)
            .into(userLike2)
        likesDetail.text = news.likesDetail
        showCom.text = news.showCom
        Glide.with(userComUrl1.context)
            .load(news.userComUrl1)
            .into(userComUrl1)
        userComAcc1.text = news.userComAcc1
        userComText1.text = news.userComText1
        userComDate1.text = news.userComDate1
        Glide.with(userComReplyUrl1.context)
            .load(news.userComReplyUrl1)
            .into(userComReplyUrl1)
        Glide.with(userComLikeUrl1.context)
            .load(news.userComLikeUrl1)
            .into(userComLikeUrl1)
        userComLike1.text = news.userComLike1.toString()
        Glide.with(postsUrl.context)
            .load(news.postsUrl)
            .into(postsUrl)
        Glide.with(postsUrl.context)
            .load(news.postsUrl)
            .into(postsUrl)
        postsCount.text = news.postsCount.toString()
        Glide.with(viewersUrl.context)
            .load(news.viewersUrl)
            .into(viewersUrl)
        viewersCount.text = news.viewersCount.toString()
        likesUrl.setOnClickListener { v ->
            if (news.liked == 1) {
                news.liked = 0
                news.likesCount = news.likesCount - 1
                Glide.with(likesUrl.context)
                    .load(R.drawable.likemin)
                    .into(likesUrl)
                likes.text = news.likesCount.toString()
                likes.setTextColor(Color.parseColor("#979899"))
                val toast = Toast.makeText(
                    v.context,
                    "Like removed!",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                thisNews = news
            } else {
                news.liked = 1
                news.likesCount = news.likesCount + 1
                Glide.with(likesUrl.getContext())
                    .load(R.drawable.likebluemin)
                    .into(likesUrl)
                likes.text = news.likesCount.toString()
                likes.setTextColor(Color.parseColor("#006ba8"))
                val toast = Toast.makeText(
                    v.context,
                    "Liked!",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                thisNews = news
            }
        }
    }
}