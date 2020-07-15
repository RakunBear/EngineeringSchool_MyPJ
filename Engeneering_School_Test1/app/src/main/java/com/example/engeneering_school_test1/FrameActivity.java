package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FrameActivity extends AppCompatActivity {

//    ImageView img1, img2;
    @BindView(R.id.img1) ImageView img1;
    @BindView(R.id.img2) ImageView img2;
    @BindView(R.id.img3) ImageView img3;
    @BindView(R.id.img4) ImageView img4;

    boolean ch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        ButterKnife.bind(this);

    }

    public void ButtonFunc1(View view)
    {
        switch (view.getId()) {
            case R.id.btn_imgC :
                if (ch)
                {
                    ch = !ch;
                    img3.setVisibility(View.VISIBLE);
                    img4.setVisibility(View.INVISIBLE);
                }
                else {
                    ch = !ch;
                    img3.setVisibility(View.INVISIBLE);
                    img4.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_imgC1 :
                Toast.makeText(getApplicationContext(), ""+img1.getResources(), Toast.LENGTH_SHORT).show();
                img1.setImageResource(R.drawable.img1);
                img2.setImageResource(R.drawable.img2);
                break;
            case R.id.btn_imgC2 :
                img1.setImageResource(R.drawable.img2);
                img2.setImageResource(R.drawable.img1);
                break;
        }
    }
}
