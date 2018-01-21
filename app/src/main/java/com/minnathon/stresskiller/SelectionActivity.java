package com.minnathon.stresskiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SelectionActivity extends AppCompatActivity {
    ImageButton study, family, love, friend, work, money, health, others;
    public static String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        study = (ImageButton) findViewById(R.id.study);
        family = (ImageButton) findViewById(R.id.family);
        love = (ImageButton) findViewById(R.id.love);
        friend = (ImageButton) findViewById(R.id.friend);
        work = (ImageButton) findViewById(R.id.work);
        money = (ImageButton) findViewById(R.id.money);
        health = (ImageButton) findViewById(R.id.health);
        others = (ImageButton) findViewById(R.id.others);

        study.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "study";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        family.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "family";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        love.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "love";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        friend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "friend";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        work.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "work";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        money.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "money";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        health.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "health";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });

        others.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selection = "others";
                startActivity(new Intent(SelectionActivity.this,ActionActivity.class));
            }
        });
    }
}
