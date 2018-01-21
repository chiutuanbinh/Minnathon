package com.minnathon.stresskiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActionActivity extends AppCompatActivity {
    ImageButton clip, quote, game;
    String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        clip = (ImageButton) findViewById(R.id.clip);
        quote = (ImageButton) findViewById(R.id.quote);
        game = (ImageButton) findViewById(R.id.game);

        clip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                action = "clip";
                startActivity(new Intent(ActionActivity.this,ClipActivity.class));
            }
        });

        quote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                action = "quote";
                startActivity(new Intent(ActionActivity.this,QuoteActivity.class));
            }
        });

        game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                action = "game";
                startActivity(new Intent(ActionActivity.this,WrackActivity.class));
            }
        });
    }
}
