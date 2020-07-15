package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import androidx.annotation.NonNull;

public class CountActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;
    int count = 10;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ButterKnife.bind(this);

        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0) {
                    text.setText(""+ msg.arg1);
                }
                else if(msg.what == 1)
                {
                    Toast.makeText(CountActivity.this, "클리어", Toast.LENGTH_SHORT).show();
                    text.setTextColor(Color.RED);
                    text.setText("Clear");
                }
            }
        };



        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) { // 현재 UI 스레드가 아니기 때문에 메시지 큐에 Runnable을 등록 함
                    count--;
//                    runOnUiThread(new Runnable() {
//                        public void run() { // 메시지 큐에 저장될 메시지의 내용
//                            text.setText("" + count);
//                        }
//                    });
                    Message msg = mHandler.obtainMessage();
                    msg.arg1 = count;
                    mHandler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                mHandler.sendEmptyMessage(1);
            }
        }).start();


    }
}
