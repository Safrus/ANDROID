package com.example.vkrecyclerviewkotlin

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.HorizontalScrollView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView
    private lateinit var image6: ImageView
    private lateinit var image7: ImageView
    private lateinit var image8: ImageView
    private lateinit var image9: ImageView
    private lateinit var image10: ImageView
    private lateinit var image11: ImageView
    private lateinit var image12: ImageView
    private lateinit var image13: ImageView
    private lateinit var image14: ImageView
    private lateinit var image15: ImageView
    private lateinit var image16: ImageView
    private lateinit var image17: ImageView
    private lateinit var image18: ImageView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsListAdapter
    private var listener: NewsListAdapter.ItemClickListener? = null
    private val recyclerState = "recycler_state"
    private lateinit var horizontalScrollView: HorizontalScrollView

    override fun onBackPressed() {
        finish()
    }

    override fun onPause() {
        super.onPause()
        // save RecyclerView state
        mBundleRecyclerViewState = Bundle()
        val listState = recyclerView.layoutManager!!.onSaveInstanceState()
        mBundleRecyclerViewState!!.putParcelable(recyclerState, listState)
    }

    override fun onResume() {
        super.onResume()
        // restore RecyclerView state
        if (mBundleRecyclerViewState != null) {
            val listState =
                mBundleRecyclerViewState!!.getParcelable<Parcelable>(
                    recyclerState
                )
            recyclerView.layoutManager!!.onRestoreInstanceState(listState)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image1 = this.findViewById(R.id.image1)
        image2 = this.findViewById(R.id.image2)
        image3 = this.findViewById(R.id.image3)
        image4 = this.findViewById(R.id.image4)
        image5 = this.findViewById(R.id.image5)
        image6 = this.findViewById(R.id.imageView6)
        image7 = this.findViewById(R.id.image7)
        image8 = this.findViewById(R.id.image8)
        image9 = this.findViewById(R.id.image9)
        image10 = this.findViewById(R.id.image10)
        image11 = this.findViewById(R.id.image11)
        image12 = this.findViewById(R.id.image12)
        image13 = this.findViewById(R.id.image13)
        image14 = this.findViewById(R.id.image14)
        image15 = this.findViewById(R.id.image15)
        image16 = this.findViewById(R.id.image16)
        image17 = this.findViewById(R.id.image17)
        image18 = this.findViewById(R.id.image18)
        Glide.with(image1.context)
            .load(R.drawable.three)
            .into(image1)
        Glide.with(image2.context)
            .load(R.drawable.down)
            .into(image2)
        Glide.with(image3.context)
            .load(R.drawable.lupa)
            .into(image3)
        Glide.with(image4.context)
            .load(R.drawable.cam)
            .into(image4)
        Glide.with(image5.context)
            .load(R.drawable.grdiv)
            .into(image5)
        Glide.with(image6.context)
            .load(R.drawable.pen)
            .into(image6)
        Glide.with(image7.context)
            .load(R.drawable.icon2)
            .into(image7)
        Glide.with(image8.context)
            .load(R.drawable.icon4)
            .into(image8)
        Glide.with(image9.context)
            .load(R.drawable.icon1)
            .into(image9)
        Glide.with(image10.context)
            .load(R.drawable.icon3)
            .into(image10)
        Glide.with(image11.context)
            .load(R.drawable.icon5)
            .into(image11)
        Glide.with(image12.context)
            .load(R.drawable.icon6)
            .into(image12)
        Glide.with(image13.context)
            .load(R.drawable.icon7)
            .into(image13)
        Glide.with(image14.context)
            .load(R.drawable.icon8)
            .into(image14)
        Glide.with(image15.context)
            .load(R.drawable.kotmin)
            .into(image15)
        Glide.with(image16.context)
            .load(R.drawable.news3)
            .into(image16)
        Glide.with(image17.context)
            .load(R.drawable.icon9)
            .into(image17)
        Glide.with(image18.context)
            .load(R.drawable.news5)
            .into(image18)
        listener = object : NewsListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: News?) {
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        horizontalScrollView = findViewById(R.id.horizontalScrollView)
        adapter = NewsListAdapter(newsGenerator(), listener)
        recyclerView.adapter = adapter
    }

    private fun newsGenerator(): List<News> {
        return DataBase.news
    }

    companion object {
        private var mBundleRecyclerViewState: Bundle? = null
    }
}