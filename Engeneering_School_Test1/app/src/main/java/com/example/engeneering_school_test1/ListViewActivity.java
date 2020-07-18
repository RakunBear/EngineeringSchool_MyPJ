package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    Context context = this;
    ArrayList<Item> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        this.InitializeData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,dataList);
//        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.layout_listview, dataList);

        listView.setAdapter(myAdapter);
//        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView parent, View v, int position, long id){
//                Toast.makeText(getApplicationContext(),
//                        position + "",
//                        Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public void InitializeData()
    {
        String name[] = getResources().getStringArray(R.array.items_name);
        String description[] = getResources().getStringArray(R.array.item_description);

        dataList = new ArrayList<Item>();

        for (int i = 0; i < name.length; i++)
            dataList.add(new Item(name[i], description[i]));

    }

    public class Item {
        private String name;
        private String description;

        public Item(String name, String description){
            this.name = name;
            this.description = description;
        }

        public String getName()
        {
            return this.name;
        }

        public String getDescription()
        {
            return this.description;
        }
    }

    public class MyAdapter extends BaseAdapter {

        Context mContext = null;
        ArrayList<Item> sample;

        public MyAdapter(Context context, ArrayList<Item> data) {
            mContext = context;
            sample = data;
        }

        @Override
        public int getCount() { // Item Size 반환
            return sample.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Item getItem(int position) {
            return sample.get(position);
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {
            if (converView == null) {
                converView = LayoutInflater.from(context)
                        .inflate(R.layout.layout_listview, parent, false);
            }

            Item currentItem = getItem(position);

            TextView text_Item_Name = (TextView) converView.findViewById(R.id.text_Name);
            TextView text_Item_Description = (TextView) converView.findViewById(R.id.text_Description);

            text_Item_Name.setText(currentItem.getName());
            text_Item_Description.setText(currentItem.getDescription());

            return converView;
        }
    }

}
