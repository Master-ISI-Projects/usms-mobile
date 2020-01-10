package com.USMS.Mobile.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.USMS.Mobile.R;

public class HomeFragment  extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accueil, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView cardViewHomeToAbout = view.findViewById(R.id.HomeToAbout);
        CardView cardViewHomeToPw = view.findViewById(R.id.HomeToPw);
        CardView cardViewHomeToWeb = view.findViewById(R.id.HomeToWeb);
        CardView cardViewHomeToFacebook = view.findViewById(R.id.HomeToFacebook);
        CardView cardViewHomeToNews = view.findViewById(R.id.HomeToNews);
        CardView cardViewHomeToEvents = view.findViewById(R.id.HomeToEvents);


        cardViewHomeToAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.USMS.Mobile.AboutActivity.class);
                startActivity(intent);
            }
        });
        cardViewHomeToPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.USMS.Mobile.PwActivity.class);
                startActivity(intent);
            }
        });
        cardViewHomeToWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.fpbm.ma/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        cardViewHomeToFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/fpbm.ma/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);;
            }
        });
        cardViewHomeToNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.USMS.Mobile.NewsActivity.class);
                startActivity(intent);
            }
        });
        cardViewHomeToEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.USMS.Mobile.EventsActivity.class);
                startActivity(intent);
            }
        });
  }

}