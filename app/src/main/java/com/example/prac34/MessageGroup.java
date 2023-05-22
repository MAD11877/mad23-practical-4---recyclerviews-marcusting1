package com.example.prac34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MessageGroup extends AppCompatActivity implements View.OnClickListener {

    private Button grp1btn;
    private Button grp2btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        grp1btn = findViewById(R.id.button3);
        grp1btn.setOnClickListener(this);
        grp2btn = findViewById(R.id.button5);
        grp2btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        TextView textViewGroup1 = findViewById(R.id.textView2);
        ImageView imageViewGroup2 = findViewById(R.id.imageView2);

        if(v.getId() == R.id.button3){
            textViewGroup1.setText("Group 1");
        }

        else if(v.getId() == R.id.button5){
            imageViewGroup2.setVisibility(View.VISIBLE);
        }
    }




}