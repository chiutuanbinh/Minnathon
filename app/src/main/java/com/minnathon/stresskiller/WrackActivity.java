package com.minnathon.stresskiller;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class WrackActivity extends AppCompatActivity {
    ImageButton hole1, hole2, hole3, hole4, hole5, hole6, hole7, hole8, hole9;
    int state1 , state2 , state3 , state4 , state5 , state6 , state7 , state8 , state9;
    TextView score;
    int s = 0;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrack);

        hole1 = (ImageButton) findViewById(R.id.hole1);
        hole2 = (ImageButton) findViewById(R.id.hole2);
        hole3 = (ImageButton) findViewById(R.id.hole3);
        hole4 = (ImageButton) findViewById(R.id.hole4);
        hole5 = (ImageButton) findViewById(R.id.hole5);
        hole6 = (ImageButton) findViewById(R.id.hole6);
        hole7 = (ImageButton) findViewById(R.id.hole7);
        hole8 = (ImageButton) findViewById(R.id.hole8);
        hole9 = (ImageButton) findViewById(R.id.hole9);

        score = (TextView) findViewById(R.id.score);

        state1 = state2 = state3 = state4 = state5 = state6 = state7 = state8 = state9 = 1;

        hole1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state1 == 2){
                    hole1.setImageResource(R.mipmap.state3);
                    state1 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state2 == 2){
                    hole2.setImageResource(R.mipmap.state3);
                    state2 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state3 == 2){
                    hole3.setImageResource(R.mipmap.state3);
                    state3 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state4 == 2) {
                    hole4.setImageResource(R.mipmap.state3);
                    state4 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state5 == 2){
                    hole5.setImageResource(R.mipmap.state3);
                    state5 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state6 == 2){
                    hole6.setImageResource(R.mipmap.state3);
                    state6 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state7 == 2){
                    hole7.setImageResource(R.mipmap.state3);
                    state7 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state8 == 2){
                    hole8.setImageResource(R.mipmap.state3);
                    state8 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
        hole9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (state9 == 2){
                    hole9.setImageResource(R.mipmap.state3);
                    state9 = 3;
                    s++;
                    score.setText(s + "");
                }
            }
        });
    }

    Handler h = new Handler();
    Runnable runnable;
    @Override
    protected void onStart() { // start handler when activity is running
        h.postDelayed(new Runnable() {
            public void run() {
                int ran = (int) (Math.random() * 5);
                if (ran == 0 && state1 == 1){
                    hole1.setImageResource(R.mipmap.state2);
                    state1 = 2;
                }
                else if (state1 == 2 || state1 == 3){
                    hole1.setImageResource(R.mipmap.state1);
                    state1 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state2 == 1){
                    hole2.setImageResource(R.mipmap.state2);
                    state2 = 2;
                }
                else if (state2 == 2 || state2 == 3){
                    hole2.setImageResource(R.mipmap.state1);
                    state2 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state3 == 1){
                    hole3.setImageResource(R.mipmap.state2);
                    state3 = 2;
                }
                else if (state3 == 2 || state3 == 3){
                    hole3.setImageResource(R.mipmap.state1);
                    state3 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state4 == 1){
                    hole4.setImageResource(R.mipmap.state2);
                    state4 = 2;
                }
                else if (state4 == 2 || state4 == 3){
                    hole4.setImageResource(R.mipmap.state1);
                    state4 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state5 == 1){
                    hole5.setImageResource(R.mipmap.state2);
                    state5 = 2;
                }
                else if (state5 == 2 || state5 == 3){
                    hole5.setImageResource(R.mipmap.state1);
                    state5 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state6 == 1){
                    hole6.setImageResource(R.mipmap.state2);
                    state6 = 2;
                }
                else if (state6 == 2 || state6 == 3){
                    hole6.setImageResource(R.mipmap.state1);
                    state6 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state7 == 1){
                    hole7.setImageResource(R.mipmap.state2);
                    state7 = 2;
                }
                else if (state7 == 2 || state7 == 3){
                    hole7.setImageResource(R.mipmap.state1);
                    state7 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state8 == 1){
                    hole8.setImageResource(R.mipmap.state2);
                    state8 = 2;
                }
                else if (state8 == 2 || state8 == 3){
                    hole8.setImageResource(R.mipmap.state1);
                    state8 = 1;
                }

                ran = (int) (Math.random() * 5);
                if (ran == 0 && state9 == 1){
                    hole9.setImageResource(R.mipmap.state2);
                    state9 = 2;
                }
                else if (state9 == 2 || state9 == 3){
                    hole9.setImageResource(R.mipmap.state1);
                    state9 = 1;
                }

                runnable = this;
                h.postDelayed(runnable, 1200);
            }
        }, 1200);
        super.onStart();
    }
}
