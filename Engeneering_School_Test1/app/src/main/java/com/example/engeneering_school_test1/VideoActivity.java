package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoView) VideoView videoView;
    @BindView(R.id.btn_play) Button btn_play;
    @BindView(R.id.btn_stop) Button btn_stop;
    @BindView(R.id.btn_reset) Button btn_reset;

//    private static final String baseURL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    private String fileName = "만월.webm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        videoView.requestFocus();
        int id = getRawResIdByName("fullmoon");
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + id);
        videoView.setVideoURI(video);

        /* Listener */
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "준비완료", Toast.LENGTH_SHORT).show();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "재생완료", Toast.LENGTH_SHORT).show();
            }
        });

        btn_play.setOnClickListener(VideoControler());
        btn_stop.setOnClickListener(VideoControler());
        btn_reset.setOnClickListener(VideoControler());
    }

    private View.OnClickListener VideoControler() {
        View.OnClickListener clickListener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_play :
                        videoView.start();
                        break;
                    case R.id.btn_stop :
                        videoView.pause();
                        break;
                    case R.id.btn_reset :
                        videoView.seekTo(0);
                        videoView.start();
                        break;
                }
            }
        };

        return clickListener;
    }

    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
