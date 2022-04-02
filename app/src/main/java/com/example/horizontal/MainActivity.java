package com.example.horizontal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.horizontal.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleActivity";
    private int currentIndex=0;
    private ActivityMainBinding binding;
    private List<Question> questionLists= Arrays.asList(
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5,false),
            new Question(R.string.question6,true)
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCrete:调用");
     binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cheat1.setOnClickListener(new View.OnClickListener() {
            final Intent intent =new Intent(MainActivity.this,SecondActivity.class);
            @Override
            public void onClick(View view) {
                String answer = String.valueOf(questionLists.get(currentIndex).isAnswer());

                intent.putExtra("answer",answer);
                startActivityForResult(intent,1);



  


            }
        });




        binding.true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        binding.false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        binding.textView1.setText(questionLists.get(currentIndex).getTextResId());
        binding.next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1)%questionLists.size();
                updateQuestion();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        binding.true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"作弊是不对的",Toast.LENGTH_SHORT).show();
            }

        });
        binding.false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"作弊是不对的",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private  void checkAnswer(boolean userAnswer){
        final boolean correntAnswer = questionLists.get(currentIndex).isAnswer();
        int msgId = correntAnswer ==userAnswer ? R.string.corrcet : R.string.incorrect;
        Toast.makeText(this,msgId,Toast.LENGTH_SHORT).show();
    }
    private void updateQuestion(){
        int resId = questionLists.get(currentIndex).getTextResId();
        binding.textView1.setText(resId);
    }







    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart:调用");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop:调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy:调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onCrete:Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume:调用");
    }
}