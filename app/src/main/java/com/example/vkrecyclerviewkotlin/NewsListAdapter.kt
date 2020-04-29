package com.example.vkrecyclerviewkotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vkrecyclerviewkotlin.NewsListAdapter.NewsViewHolder

class NewsListAdapter : RecyclerView.Adapter<NewsViewHolder?> {
    private var newsList: List<News>
    private lateinit var listener: ItemClickListener

    constructor(newsList: List<News>) {
        this.newsList = newsList
    }

    constructor(newsList: List<News>, listener: ItemClickListener?) {
        this.newsList = newsList
        if (listener != null) {
            this.listener = listener
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, null, false)
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        Glide.with(holder.accountPhotoUrl.context)
            .load(news.accountPhotoUrl)
            .into(holder.accountPhotoUrl)
        holder.accountName.text = news.accountName
        holder.date.text = news.date
        holder.newsText.text = news.newsText
        Glide.with(holder.postPhotoUrl.context)
            .load(news.postPhotoUrl)
            .into(holder.postPhotoUrl)
        if (news.liked == 1) {
            Glide.with(holder.likesUrl.context)
                .load(R.drawable.likebluemin)
                .into(holder.likesUrl)
            holder.likesCount.setTextColor(Color.parseColor("#006ba8"))
        } else {
            Glide.with(holder.likesUrl.context)
                .load(R.drawable.likemin)
                .into(holder.likesUrl)
            holder.likesCount.setTextColor(Color.parseColor("#979899"))
        }
        holder.likesCount.text = news.likesCount.toString()
        Glide.with(holder.commentsUrl.context)
            .load(news.commentsUrl)
            .into(holder.commentsUrl)
        holder.commentsCount.text = news.commentsCount.toString()
        Glide.with(holder.postsUrl.context)
            .load(news.postsUrl)
            .into(holder.postsUrl)
        holder.postsCount.text = news.postsCount.toString()
        Glide.with(holder.viewersUrl.context)
            .load(news.viewersUrl)
            .into(holder.viewersUrl)
        holder.viewersCount.text = news.viewersCount.toString()
        holder.itemView.setOnClickListener {
            listener.itemClick(position, news)
        }
        holder.likesUrl.setOnClickListener { v ->
            if (news.liked == 1) {
                news.liked = 0
                news.likesCount = news.likesCount - 1
                Glide.with(holder.likesUrl.context)
                    .load(R.drawable.likemin)
                    .into(holder.likesUrl)
                holder.likesCount.text = news.likesCount.toString()
                holder.likesCount.setTextColor(Color.parseColor("#979899"))
                val toast = Toast.makeText(
                    v.context,
                    "Like removed!",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            } else {
                news.liked = 1
                news.likesCount = news.likesCount + 1
                Glide.with(holder.likesUrl.context)
                    .load(R.drawable.likebluemin)
                    .into(holder.likesUrl)
                holder.likesCount.text = news.likesCount.toString()
                holder.likesCount.setTextColor(Color.parseColor("#006ba8"))
            }
        }
    }


    inner class NewsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var accountPhotoUrl: ImageView = itemView.findViewById(R.id.accountPhotoUrl)
        var accountName: TextView = itemView.findViewById(R.id.accountName)
        var date: TextView = itemView.findViewById(R.id.date)
        var newsText: TextView = itemView.findViewById(R.id.newsText)
        var postPhotoUrl: ImageView = itemView.findViewById(R.id.postPhotoUrl)
        var likesUrl: ImageView = itemView.findViewById(R.id.likesUrl)
        var likesCount: TextView = itemView.findViewById(R.id.likesCount)
        var commentsUrl: ImageView = itemView.findViewById(R.id.commentsUrl)
        var commentsCount: TextView = itemView.findViewById(R.id.commentsCount)
        var postsUrl: ImageView = itemView.findViewById(R.id.postsUrl)
        var postsCount: TextView = itemView.findViewById(R.id.postsCount)
        var viewersUrl: ImageView = itemView.findViewById(R.id.viewersUrl)
        var viewersCount: TextView = itemView.findViewById(R.id.viewersCount)

    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: News?)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}