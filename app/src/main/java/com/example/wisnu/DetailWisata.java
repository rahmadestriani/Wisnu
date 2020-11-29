package com.example.wisnu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailWisata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_detail_wisata);

        TextView mTitleText = findViewById(R.id.wisataTitle);
        TextView mCategoryText = findViewById(R.id.wisataCategory);
        ImageView mWisataImage = findViewById(R.id.wisataImage);

        mTitleText.setText(getIntent().getStringExtra("nama"));
        mCategoryText.setText("Kategori Wisata: "+ getIntent().getStringExtra( "kategori"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambarUrl")).error(R.mipmap.ic_wisnu).override(512, 512).into(mWisataImage);
    }
}