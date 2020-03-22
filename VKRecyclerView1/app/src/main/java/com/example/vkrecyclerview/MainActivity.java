package com.example.vkrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;
    private ImageView image13;
    private ImageView image14;
    private ImageView image15;
    private ImageView image16;
    private ImageView image17;
    private ImageView image18;

    private RecyclerView recyclerView;

    private NewsListAdapter adapter;

    private NewsListAdapter.ItemClickListener listener = null;

    private final String KEY_RECYCLER_STATE = "recycler_state";

    private static Bundle mBundleRecyclerViewState;

    private HorizontalScrollView horizontalScrollView;


    public void onBackPressed() {

        MainActivity.this.finish();

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        // save RecyclerView state
        mBundleRecyclerViewState = new Bundle();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        // restore RecyclerView state
        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        image6=findViewById(R.id.imageView6);
        image7=findViewById(R.id.image7);
        image8=findViewById(R.id.image8);
        image9=findViewById(R.id.image9);
        image10=findViewById(R.id.image10);
        image11=findViewById(R.id.image11);
        image12=findViewById(R.id.image12);
        image13=findViewById(R.id.image13);
        image14=findViewById(R.id.image14);
        image15=findViewById(R.id.image15);
        image16=findViewById(R.id.image16);
        image17=findViewById(R.id.image17);
        image18=findViewById(R.id.image18);

        Glide.with(image1.getContext())
                .load(R.drawable.three)
                .into(image1);
        Glide.with(image2.getContext())
                .load(R.drawable.down)
                .into(image2);
        Glide.with(image3.getContext())
                .load(R.drawable.lupa)
                .into(image3);
        Glide.with(image4.getContext())
                .load(R.drawable.cam)
                .into(image4);
        Glide.with(image5.getContext())
                .load(R.drawable.grdiv)
                .into(image5);
        Glide.with(image6.getContext())
                .load(R.drawable.pen)
                .into(image6);
        Glide.with(image7.getContext())
                .load(R.drawable.icon2)
                .into(image7);
        Glide.with(image8.getContext())
                .load(R.drawable.icon4)
                .into(image8);
        Glide.with(image9.getContext())
                .load(R.drawable.icon1)
                .into(image9);
        Glide.with(image10.getContext())
                .load(R.drawable.icon3)
                .into(image10);
        Glide.with(image11.getContext())
                .load(R.drawable.icon5)
                .into(image11);
        Glide.with(image12.getContext())
                .load(R.drawable.icon6)
                .into(image12);
        Glide.with(image13.getContext())
                .load(R.drawable.icon7)
                .into(image13);
        Glide.with(image14.getContext())
                .load(R.drawable.icon8)
                .into(image14);
        Glide.with(image15.getContext())
                .load(R.drawable.kotmin)
                .into(image15);
        Glide.with(image16.getContext())
                .load(R.drawable.news3)
                .into(image16);
        Glide.with(image17.getContext())
                .load(R.drawable.icon9)
                .into(image17);
        Glide.with(image18.getContext())
                .load(R.drawable.news5)
                .into(image18);

        listener = new NewsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("news", item);
                startActivity(intent);
            }
        };

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        horizontalScrollView=findViewById(R.id.horizontalScrollView);
        adapter = new NewsListAdapter(newsGenerator(), listener);
        recyclerView.setAdapter(adapter);
    }



    private List<News> newsGenerator() {
        List<News>items=DataBase.news;

        return items;
    }
}