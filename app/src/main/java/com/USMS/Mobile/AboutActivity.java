package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(R.string.menu_university_infos);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // get our html content
        String htmlAsString = getString(R.string.about);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

// set the html content on the TextView
        TextView textView = (TextView) findViewById(R.id.zp);
        textView.setText(htmlAsSpanned);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
