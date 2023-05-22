package com.example.prac34;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn;
    private Button rightBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        rightBtn = findViewById(R.id.button2);
        rightBtn.setOnClickListener(this);


        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.editTextText);
        int randomNum = intent.getIntExtra("Random num", 0);

        textView.setText("MAD " + randomNum);

    }



    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button){
            if (btn.getText().equals("FOLLOW")){
                btn.setText("UNFOLLOW");
                Context context = MainActivity.this;
                String text = "Followed";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText(text);
            }
            else if (btn.getText().equals("UNFOLLOW")){
                btn.setText("FOLLOW");
            }
        }



        else if(v.getId() == R.id.button2){
            Intent intent = new Intent(MainActivity.this, MessageGroup.class);
            startActivity(intent);
        }


    }

























}