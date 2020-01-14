package com.USMS.Mobile.ui;

import android.os.Bundle;
import android.util.Log;
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

import com.USMS.Mobile.Helpers.Constant;
import com.USMS.Mobile.R;
import com.USMS.Mobile.models.NewsItem;
import com.USMS.Mobile.models.NewsItemAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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


        final Gson gson = new Gson();
        String url = Constant.API_URL + "/news";


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String r = response.toString();
                        Log.d("-----test------", r);
                        Type listOfMyClassObject = new TypeToken<ArrayList<NewsItem>>() {}.getType();
                        ArrayList<NewsItem> newsItems = gson.fromJson(response, listOfMyClassObject);
                        Log.d("test", "start -----------------------");
                        itemList = new ArrayList<NewsItem>();
                        for(NewsItem newsItem: newsItems) {
                            NewsItem item = new NewsItem(newsItem.getId(), newsItem.getTitle(), newsItem.getImage(), newsItem.getDescription(), newsItem.getPublished_at(), newsItem.getScholar_year_id(), newsItem.getCreatedAt());
                            itemList.add(item);
                        }
                        myAdapter = new NewsItemAdapter(getActivity(), itemList);
                        recyclerView.setAdapter(myAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ok", error.toString());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);










        /*itemList = new ArrayList<NewsItem>();
        itemList.add(new NewsItem(1, "19/21/1111","zz","aze","aze","aze","aze"));


        myAdapter = new NewsItemAdapter(getActivity(), itemList);
        recyclerView.setAdapter(myAdapter);*/


    }

}
