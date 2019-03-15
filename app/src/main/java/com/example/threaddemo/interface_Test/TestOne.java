package com.example.threaddemo.interface_Test;

import android.util.Log;

public interface TestOne {

     default void msg()
    {
     Log.e("DetailOfThe","TestOne");
    }

    public  static void staticMsg()
    {
        Log.e("DetailOfThe","TestOne");
    }

    public void test();

    default void msgOps()
    {
        Log.e("msgOps","msgOps");
    }
}
