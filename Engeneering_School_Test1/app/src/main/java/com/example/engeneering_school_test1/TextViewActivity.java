package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity {


    Button btnTest2 = null;
    TextView textView = null;
    boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);


        btnTest2 = findViewById(R.id.btnTest2);
        textView = findViewById(R.id.context);


        btnTest2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeContext();
            }

            private void ChangeContext() {
                if (check)
                    textView.setText("True");
                else
                    textView.setText("False");

                check = !check;
            }
        });
    }
}
