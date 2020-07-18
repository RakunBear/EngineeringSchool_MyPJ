package com.example.engeneering_school_test1;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CallBookAdapter extends BaseAdapter {

    Context mContext = null;
    ArrayList<CallBookItem> dataList;

    public CallBookAdapter(Context context, ArrayList<CallBookItem> data) {
        mContext = context;
        dataList = data;
    }

    @Override
    public int getCount() { // Item Size 반환
        return dataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public CallBookItem getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_call_book, parent, false);
        }

        CallBookItem currentItem = getItem(position);
        TextView text_Item_Name = (TextView) convertView.findViewById(R.id.text_Name);
        TextView text_Item_Num = (TextView) convertView.findViewById(R.id.text_Num);

        text_Item_Name.setText(currentItem.getName());
        text_Item_Num.setText(currentItem.getNum());

        return convertView;
    }
}
