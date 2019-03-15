package com.example.threaddemo.interface_Test;

import android.util.Log;

public interface TestThree {

    default void msg()
    {
        Log.e("DetailOfThe","TestOne");
    }
}
