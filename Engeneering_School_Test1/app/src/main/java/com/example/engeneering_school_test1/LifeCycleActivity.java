package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d("LifeCycle", "Run OnCreate");
    }

    @Override
    protected  void onStart() {
        super.onStart();

        Log.d("LifeCycle", "Run OnStart");
    }

    @Override
    protected  void onResume() {
        super.onResume();

        Log.d("LifeCycle", "Run onResume");
    }

    @Override
    protected  void onPause() {
        super.onPause();

        Log.d("LifeCycle", "Run onPause");
    }

    @Override
    protected  void onStop() {
        super.onStop();

        Log.d("LifeCycle", "Run onStop");
    }

    @Override
    protected  void onRestart() {
        super.onRestart();

        Log.d("LifeCycle", "Run onRestart");
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();

        Log.d("LifeCycle", "Run onDestroy");
    }
}
