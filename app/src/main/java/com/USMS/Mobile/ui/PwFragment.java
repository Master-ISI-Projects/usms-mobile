package com.USMS.Mobile.ui;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.USMS.Mobile.R;

import java.util.ArrayList;

public class PwFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pw, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get our html content
        String htmlAsString = getString(R.string.pw_word_text);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

// set the html content on the TextView
        TextView textView = (TextView) view.findViewById(R.id.pv_word_text);
        textView.setText(htmlAsSpanned);

    }
}
