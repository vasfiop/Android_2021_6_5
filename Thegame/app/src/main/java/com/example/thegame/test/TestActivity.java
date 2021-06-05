package com.example.thegame.test;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thegame.R;

public class TestActivity extends AppCompatActivity {
    private ImageView imageView;
    int i = R.drawable.test_red_128;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);
        imageView = findViewById(R.id.image);
        imageView.setImageResource(i);
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }
}
