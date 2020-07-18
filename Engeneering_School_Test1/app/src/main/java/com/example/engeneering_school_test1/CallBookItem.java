package com.example.engeneering_school_test1;

import android.util.Log;

public class CallBookItem {
    private String name;
    private String num;

    public CallBookItem(String name, String num){
        this.name = name;
        this.num = num;
    }

    public String getName()
    {
        return this.name;
    }

    public String getNum()
    {
        return this.num;
    }
}
