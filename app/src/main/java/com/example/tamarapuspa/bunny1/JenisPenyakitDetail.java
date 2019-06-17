package com.example.tamarapuspa.bunny1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class JenisPenyakitDetail extends AppCompatActivity {

    TextView mTitleTv, mDetailTv;
    ImageView mImageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_penyakit_detail);

        //Action bar
        ActionBar actionBar = getSupportActionBar();

        //Action bar title
        actionBar.setTitle("Jenis Penyakit Detail");

        //set back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //initialize views
        mTitleTv = findViewById(R.id.titleTv);
        mDetailTv = findViewById(R.id.descriptionTv);
        mImageIv = findViewById(R.id.imageView);

        //get data from intent
        byte[] bytes = getIntent().getByteArrayExtra("image");
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0 , bytes.length);

        //set data to views
        mTitleTv.setText(title);
        mDetailTv.setText(desc);
        mImageIv.setImageBitmap(bmp);
    }

    //handle onBackPressed (go to previous activity)
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
