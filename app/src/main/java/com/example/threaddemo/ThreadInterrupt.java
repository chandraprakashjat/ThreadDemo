package com.example.threaddemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThreadInterrupt extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_interrupt);

        Test test = new Test(1);

        Log.e("isDaemon",test.isDaemon() + "");


        test.setDaemon(true);
        test.start();



        Log.e("isDaemon",test.isDaemon() + "");








    }







    class  Test extends Thread
    {

        int id ;

        Test(int id)
        {
          this.id = id;
        }
        @Override
        public void run()
        {
            super.run();

            Log.e("Run","Run " + id);

                Log.e("RunCall","Run Call " + id);


            Test1 test = new Test1(2);

            Log.e("isDaemon",test.isDaemon() + "" + id);

            test.start();

                try {
                    sleep(10000);
                } catch (InterruptedException e)
                {

                    Log.e("InterruptedException",e.toString() + " is Interrupted"+ id);
                    e.printStackTrace();
                }


                Log.e("AfterSleep","After Sleep "+ id);

                for( int i=0;i<10;i++)
                {
                    Log.e("For loop","After Sleep "+id);
                }


        }
    }


    class  Test1 extends Thread
    {

        int id ;

        Test1(int id)
        {
            this.id = id;
        }
        @Override
        public void run()
        {
            super.run();

            Log.e("Run","Run " + id);

            Log.e("Run","Run  Test1" + isDaemon());




        }
    }

}
