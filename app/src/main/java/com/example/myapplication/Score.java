package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
public class Score extends AppCompatActivity {
    private String score;
    private TextView sc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Intent intent = getIntent();

        score=intent.getStringExtra("score");
        sc=(TextView) findViewById(R.id.textView2);
        sc.setText("note : "+score+"/20");
        System.out.println("note : "+score);



      }


}