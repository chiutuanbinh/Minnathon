package com.minnathon.stresskiller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class ClipActivity extends YouTubeBaseActivity {
    private final String APIkey = "AIzaSyAX_ZpsJXHTvqPmR6DKfbLuZKwsivsoxIY";

    private ImageButton play, next;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private TextView tx;
    private List<Film> ClipList = new ArrayList<>();
    YouTubePlayer mPlayer ;

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);

        if (!isConnected(this)){
            Toast toast = Toast.makeText(getApplicationContext(), "No Internet connection", Toast.LENGTH_SHORT);
            TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
            tv.setGravity(Gravity.CENTER);
            toast.show();
        }

        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.setShowFullscreenButton(false);
                mPlayer = youTubePlayer;
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        db.createDefaultMusic();


        youTubePlayerView.initialize(APIkey,onInitializedListener);
        play = (ImageButton)findViewById(R.id.button);
        next = (ImageButton)findViewById(R.id.button0);
        play.setVisibility(View.VISIBLE);
        next.setVisibility(View.INVISIBLE);
        tx = (TextView) findViewById(R.id.editText);
        final int count = db.getFilmsCount();
        ClipList = db.getAllFilms();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                int i = (int)(Math.random()*count);

                mPlayer.loadVideo(ClipList.get(i).getFilmLink());
                tx.setText(ClipList.get(i).getFilmTitle());
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = (int)(Math.random()*count);

                mPlayer.loadVideo(ClipList.get(i).getFilmLink());
                tx.setText(ClipList.get(i).getFilmTitle());
            }
        });

    }

}