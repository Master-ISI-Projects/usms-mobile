package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    TextView tvTitle, tvDescription, tvPublished_at, tvScholar_year_id, tvCreatedAt;
    ImageView tvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);



        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvImage = findViewById(R.id.news_image);
        tvDescription = findViewById(R.id.news_description);
        tvPublished_at = findViewById(R.id.news_published_at);
        tvScholar_year_id = findViewById(R.id.news_scholar_year_id);

        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String description = getIntent().getStringExtra("description");
        String published_at = getIntent().getStringExtra("published_at");
        String scholar_year_id = getIntent().getStringExtra("scholar_year_id");



        Picasso.get().load(image).into(tvImage);
        tvDescription.setText("Description :"+description);
        tvPublished_at.setText("publié à : "+published_at);
        tvScholar_year_id.setText("Année scolaire : "+scholar_year_id);
        setTitle(title);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
