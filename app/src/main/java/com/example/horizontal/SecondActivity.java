package com.example.horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.horizontal.databinding.ActivitySecondBinding;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent=getIntent();
        final String answer= intent.getStringExtra("answer");

        binding.ShowAnswer.setOnClickListener(view -> {
            final Intent returnIntent =new Intent();
            binding.cheatAnswer.setText(answer);
            setResult(RESULT_OK,returnIntent);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            },1000); // 延时1秒



        });

    }
}