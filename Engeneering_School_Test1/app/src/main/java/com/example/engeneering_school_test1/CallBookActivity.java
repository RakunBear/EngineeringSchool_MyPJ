package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class CallBookActivity extends AppCompatActivity {

    Context context = this;
    ArrayList<CallBookItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_book);

        this.InitializeData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final CallBookAdapter adapter = new CallBookAdapter(context, dataList);

        listView.setAdapter(adapter);
    }

    private void InitializeData() {
        String name[] = getResources().getStringArray(R.array.item_CallName);
        String num[] = getResources().getStringArray(R.array.item_CallNum);
        dataList = new ArrayList<CallBookItem>();

        for (int i = 0; i < name.length; i++) {
            dataList.add(new CallBookItem(name[i], num[i]));
        }

    }
}
