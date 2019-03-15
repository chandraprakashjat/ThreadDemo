package com.example.threaddemo.interface_Test;

import android.util.Log;

public interface TestTwo extends TestOne,TestThree {

   default void msg()
    {
        Log.e("DetailOfThe","TestTwo");
    }
    public void test();

    default void msg2()
    {
        Log.e("DetailOfThe","TestOne");
    }

    static void staticMsg()
    {
        Log.e("DetailOfThe","TestOne");
    }
}
