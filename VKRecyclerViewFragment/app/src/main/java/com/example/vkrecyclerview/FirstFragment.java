package com.example.vkrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.vkrecyclerview.DataBase;
import com.example.vkrecyclerview.News;
import com.example.vkrecyclerview.NewsDetailActivity;
import com.example.vkrecyclerview.NewsListAdapter;
import com.example.vkrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    public List<News> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsListAdapter adapter;
    private NewsListAdapter.ItemClickListener listener = null;
    public static final String TAG = "FirstFragmentTag";
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ImageView image1=getView().findViewById(R.id.image1);
        ImageView image2=getView().findViewById(R.id.image2);
        ImageView image3=getView().findViewById(R.id.image3);
        ImageView image4=getView().findViewById(R.id.image4);
        ImageView image5=getView().findViewById(R.id.image5);
        ImageView image6=getView().findViewById(R.id.imageView6);
        ImageView image7=getView().findViewById(R.id.image7);
        ImageView image8=getView().findViewById(R.id.image8);
        ImageView image9=getView().findViewById(R.id.image9);
        ImageView image10=getView().findViewById(R.id.image10);
        ImageView image11=getView().findViewById(R.id.image11);
        ImageView image12=getView().findViewById(R.id.image12);
        ImageView image13=getView().findViewById(R.id.image13);
        ImageView image14=getView().findViewById(R.id.image14);
        ImageView image15=getView().findViewById(R.id.image15);
        ImageView image16=getView().findViewById(R.id.image16);
        ImageView image17=getView().findViewById(R.id.image17);
        ImageView image18=getView().findViewById(R.id.image18);

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
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        listener = new NewsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("news", item);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        };
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsListAdapter(newsGenerator(), listener);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        mBundleRecyclerViewState = new Bundle();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);
    }


    public FirstFragment() {
        // Required empty public constructor
    }



    public List<News> newsGenerator() {
        items = DataBase.news;
        return items;
    }

}