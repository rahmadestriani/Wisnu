package com.example.wisnu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class welcome extends AppCompatActivity {

    private Button btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        btnLihat.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

    }

    private void initView() {
        btnLihat = findViewById(R.id.btn_mulai);
    }
}