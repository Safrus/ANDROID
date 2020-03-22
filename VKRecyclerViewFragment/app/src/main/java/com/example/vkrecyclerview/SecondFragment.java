package com.example.vkrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vkrecyclerview.News;
import com.example.vkrecyclerview.NewsDetailActivity;
import com.example.vkrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    public static List<News> favoriteItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private FavouriteNewsListAdapter adapter;

    private FavouriteNewsListAdapter.ItemClickListener listener = null;

    public static final String TAG = "SecondFragmentTag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener = new FavouriteNewsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("news", item);
                startActivity(intent);
            }
        };
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FavouriteNewsListAdapter(newsGenerator(), listener);
        recyclerView.setAdapter(adapter);
        return view;
    }


    public SecondFragment() {
        // Required empty public constructor
    }
    private List<News> newsGenerator() {
        return favoriteItems;
    }

}
