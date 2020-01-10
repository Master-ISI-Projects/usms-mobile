package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class PwActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw);

        setTitle(R.string.menu_Presedent_word);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // get our html content
        String htmlAsString = getString(R.string.pw_word_text);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

// set the html content on the TextView
        TextView textView = (TextView) findViewById(R.id.pv_word_text);
        textView.setText(htmlAsSpanned);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
