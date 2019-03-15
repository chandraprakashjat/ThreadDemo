package com.example.threaddemo;

import android.util.Log;

import com.example.threaddemo.interface_Test.TestOne;
import com.example.threaddemo.interface_Test.TestTwo;

public class ThreadClass
{

    ThreadClass(TestOne testTwo)
    {
      testTwo.msgOps();
    }

    ThreadClass()
    {

    }

    public   static  synchronized    void callMehtod(MainActivity.RunnableTest runnableTest, int id)
    {

        Log.e("In Method for the ",id+"");

        //synchronized (runnableTest)
        {
            for( int i= 0; i<50;i++)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                Log.e("Detail", id + " " );
            }
        }


        Log.e( " End for",id + "");   }


    public  synchronized  void callMehtod2(MainActivity.RunnableTest runnableTest, int id)
    {

        Log.e("In Method for the ",id+"");

       //synchronized (runnableTest)
        {
            for( int i= 0; i<50;i++)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                Log.e("Detail", id + " " );
            }
        }


        Log.e( " End for",id + "");   }


}
