package com.example.prac34;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.content.DialogInterface;

import android.widget.ImageView;


import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Random;
import java.util.ArrayList;



public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(this);

        recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Creating User Objects
        ArrayList<User> userList = new ArrayList<>();
        int count = 0;


        while (count < 20){

            Random random1 = new Random();
            int randomNum1 = random1.nextInt();
            String Name = "Name" + String.valueOf(randomNum1);

            Random random2 = new Random();
            int randomNum2 = random2.nextInt();
            String Desc = String.valueOf(randomNum2);

            Random random3 = new Random();
            int id = random3.nextInt();

            Random random4 = new Random();
            boolean boolVal = random4.nextInt(2) == 0;

            User userObj = new User(Name,Desc,id,boolVal);
            userList.add(userObj);
            count++;
        }

        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onClick(View v) {


        if (v == imageView) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Profile")
                    .setMessage("MADness")
                    .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Random random = new Random();
                            int randomNumber = random.nextInt();
                            Intent intent = new Intent(ListActivity.this, MainActivity.class);
                            intent.putExtra("Random num", randomNumber);
                            startActivity(intent);
                        }
                    });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
    }


}