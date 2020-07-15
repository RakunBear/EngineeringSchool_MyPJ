package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressBarActivity extends AppCompatActivity {

    @BindView(R.id.progressBar1) ProgressBar progressBar1;
    @BindView(R.id.progressBar2) ProgressBar progressBar2;
    @BindView(R.id.seekBar1) SeekBar seekBar1;
    @BindView(R.id.seekBar2) SeekBar seekBar2;
    @BindView(R.id.ratingBar) RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);

        seekBar1.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBar2.setOnSeekBarChangeListener(seekBarChangeListener);
        ratingBar.setOnRatingBarChangeListener(ratingBarChangeListener);
    }

    private void UpdateProgressBar(int _progress_Value, int _id) {
        switch (_id) {
            case 1 :
                progressBar1.setProgress(_progress_Value);
                break;
            case 2 :
                progressBar2.setProgress(_progress_Value);
                break;
        }

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()) {
                case R.id.seekBar1 :
                    UpdateProgressBar(progress, 1);
                    break;
                case R.id.seekBar2 :
                    UpdateProgressBar(progress, 2);
                    break;
            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "SeekBar Start", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "SeekBar Stop", Toast.LENGTH_SHORT).show();
        }
    };

    private RatingBar.OnRatingBarChangeListener ratingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Toast.makeText(ProgressBarActivity.this, "값 = " + rating, Toast.LENGTH_SHORT).show();
        }
    };
}
