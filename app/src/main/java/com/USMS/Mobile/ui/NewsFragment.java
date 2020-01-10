package com.USMS.Mobile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.USMS.Mobile.R;
import com.USMS.Mobile.models.NewsItem;
import com.USMS.Mobile.models.NewsItemAdapter;

import java.util.ArrayList;

public class NewsFragment extends Fragment{

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NewsItem> itemList;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.news_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<NewsItem>();
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));
        itemList.add(new NewsItem("Yassine", "19/21/1111"));

        myAdapter = new NewsItemAdapter(getActivity(), itemList);
        recyclerView.setAdapter(myAdapter);


    }

}
