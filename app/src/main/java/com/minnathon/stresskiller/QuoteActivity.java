package com.minnathon.stresskiller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class QuoteActivity extends AppCompatActivity {
    private ImageView IV;
    private ImageButton play, next;
    private List<Quote> QuoteList = new ArrayList<>();
    private String QtypeString = SelectionActivity.selection;
    private int runningIndex = 0;

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        QuoteDBHelper db = new QuoteDBHelper(this);

        if (!isConnected(this)){
            Toast toast = Toast.makeText(getApplicationContext(), "No Internet connection", Toast.LENGTH_SHORT);
            TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
            tv.setGravity(Gravity.CENTER);
            toast.show();
        }

        db.createDefaultDB();

        final int dbEle = db.getQuotesCount();
        IV = (ImageView) findViewById(R.id.imageView);
        play = (ImageButton) findViewById(R.id.button1);
        next = (ImageButton) findViewById(R.id.button2);
        play.setVisibility(View.VISIBLE);
        next.setVisibility(View.INVISIBLE);

        QuoteList = db.getAllQuotes();

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                play.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);

                while (!(QuoteList.get(runningIndex).getType().equals(QtypeString))) {
                    runningIndex = (runningIndex + 1)%dbEle;
                }
                Picasso.with(getApplicationContext()).load(QuoteList.get(runningIndex).getLink()).into(IV);
                runningIndex = (runningIndex + 1)%dbEle;

            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                while (!(QuoteList.get(runningIndex).getType().equals(QtypeString))) {
                    runningIndex = (runningIndex + 1)%dbEle;
                }
                Picasso.with(getApplicationContext()).load(QuoteList.get(runningIndex).getLink()).into(IV);
                runningIndex = (runningIndex + 1)%dbEle;

            }
        });
    }
}
