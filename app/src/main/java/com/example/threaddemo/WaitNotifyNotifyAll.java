package com.example.threaddemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.threaddemo.interface_Test.TestOne;
import com.example.threaddemo.interface_Test.TestThree;
import com.example.threaddemo.interface_Test.TestTwo;

public   class WaitNotifyNotifyAll extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    ThreadClass threadClass = new ThreadClass();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_notify_notify_all);


        button = findViewById(R.id.button2);

        button.setOnClickListener(this);





        WaitingThread waitingThread = new WaitingThread(1);


        Log.e("Is Alive Method 1.0 ",waitingThread.isAlive() + "");
        waitingThread.start();

        waitingThread.interrupt();

        new WaitingThread(2).start();


//        Log.e("Is Alive Method 1",waitingThread.isAlive() + "");
//
//        Log.e("is Call","is call");
//
//        new WaitingThread(2).start();
//
//
//        new WaitingThread(3).start();
//
//        Log.e("it wouldRun","it would run");
//
//
//
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                Log.e("Is Alive Method 1.1",waitingThread.isAlive() + "");
//            }
//        }, 500);

    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.button2:




                break;
        }

    }




    class  WaitingThread extends  Thread
    {
        int id ;
        WaitingThread(int i)
        {
           id = i;
        }
        @Override
        public void run() {
            super.run();
            Log.e("it WaitingThread First","WaitingThread First " + id);

           synchronized (threadClass)
           {
               while (true)
               {
                   try {
                       sleep(1000);
                       Log.e("it WaitingThread wait", id + "");


                   } catch (Exception e) {
                       e.printStackTrace();
                   }

                   if(isInterrupted())
                   {
Log.e("itsInterrupted","isInterruped");
                   }
               }
           }


        }
    }


}
