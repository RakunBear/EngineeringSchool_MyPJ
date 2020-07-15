package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainLobbyActivity extends AppCompatActivity {

    Intent intent;
    Context context = this;

    @BindView(R.id.mainTableLayout) TableLayout mainTableLayout;
    @BindView(R.id.btn1_1) Button btn1_1;
    @BindView(R.id.btn1_2) Button btn1_2;
    @BindView(R.id.btn1_3) Button btn1_3;
    @BindView(R.id.btn2_1) Button btn2_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lobby);

    }

    /*
   테이블 레이아웃에서 버튼 가져오기
   return List<View>
 */
    public List<View> getAllButtons(ViewGroup layout){
        List<View> viewList = new ArrayList<>();
        for(int i =0; i< layout.getChildCount(); i++){
            View v =layout.getChildAt(i); //해당 테이블로우 전부 가져오기
            viewList.addAll(v.getTouchables()); //해당 테이블로우의 버튼 id 전부 가져오기
        }
        return viewList;
    }

    public void ButtonFunc(View view)
    {
        switch (view.getId()) {
            // 연습
            case R.id.btn1_1 :
                intent = new Intent(context, TextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_2 :
                intent = new Intent(context, RelativeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_3 :
                intent = new Intent(context, FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_4 :
                intent = new Intent(context, LinearActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_5 :
                intent = new Intent(context, CountActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_6 :
                intent = new Intent(context, WebActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_7 :
                intent = new Intent(context, VideoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_8 :
                intent = new Intent(context, RadioActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1_9 :
                intent = new Intent(context, ProgressBarActivity.class);
                startActivity(intent);
                break;
            // 과제
            case R.id.btn2_1 :
                intent = new Intent(context, CaculatorActivity.class);
                startActivity(intent);
                break;
        }
    }
}
