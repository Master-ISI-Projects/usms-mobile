package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.USMS.Mobile.models.NewsItem;
import com.USMS.Mobile.models.NewsItemAdapter;
import com.USMS.Mobile.ui.NewsFragment;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NewsItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.menu_news);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.news_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
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

        myAdapter = new NewsItemAdapter(this, itemList);
        recyclerView.setAdapter(myAdapter);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
