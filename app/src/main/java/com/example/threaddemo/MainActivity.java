package com.example.threaddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.threaddemo.interface_Test.TestOne;
import com.example.threaddemo.interface_Test.TestTwo;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener, TestTwo, TestOne
{

    Button createButton;
    Test test;

    ThreadClass threadClass;

    ThreadClass th= new ThreadClass();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = findViewById(R.id.button);
        createButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
       switch (v.getId())
       {
           case R.id.button:

               createThread();

               break;
       }
    }

    private void createThread()
    {

        int i = 1;
        Log.e("CreateThead",i+"is");

        RunnableTest runnableTest1 = new RunnableTest();

        RunnableTest runnableTest2 = new RunnableTest();



        Test thread = new Test(1,runnableTest1);
        thread.start();



        Test thread2 = new Test(2,runnableTest2);
        thread2.start();




        //Way:- 2
       Thread thread1 = new Thread(new Runnable()
       {
            @Override
            public void run()
            {

            }
        });



       TestDemo testDemo = new TestDemo()
       {
           @Override
           public void test()
           {
              Log.e("jsdf","test");
           }
       };

      // testDemo.test();


       //Way 3:-
       Runnable runnable = new Runnable() {
           @Override
           public void run() {

           }
       };


      // Thread thread2 = new Thread(runnable);

      // thread2.start();

    }

    @Override
    public void msg() {

    }

    @Override
    public void test() {

    }

    @Override
    public void msg2() {

    }


    class Test extends Thread
    {

        int id ;
        RunnableTest runnableTest;
        Test ( int id,RunnableTest runnableTest)
        {
            Log.e("callFor",id + "");
            this.id = id;
            this.runnableTest = runnableTest;


        }
        @Override
        public void run()
        {
            super.run();

           callMehtod(runnableTest,id);
//            if (id == 1)
//            {
//                ThreadClass th= new ThreadClass();
//                th.callMehtod(runnableTest,id);
//            }else
//            {
//                ThreadClass th= new ThreadClass();
//                th.callMehtod(runnableTest,id);
//            }


        }
    }


    class Test2 extends Thread
    {

        int id ;
        RunnableTest runnableTest;
        Test2 ( int id,RunnableTest runnableTest)
        {
            Log.e("callFor",id + "");
            this.id = id;
            this.runnableTest = runnableTest;


        }
        @Override
        public void run()
        {
            super.run();



            th.callMehtod(runnableTest,id);


        }
    }
    class RunnableTest implements Runnable
    {


        @Override
        public void run()
        {



        }

    }

    private void callMehtod2(RunnableTest runnableTest, int id)
    {

        Log.e("callMehtod2",id+"");
    }

    private void callMehtod3(RunnableTest runnableTest, int id)
    {

        Log.e("callMehtod3",id+"");
    }

    private  static synchronized   void callMehtod(RunnableTest runnableTest,int id)
    {

        Log.e("CallFor the",id+"");

        //synchronized (runnableTest)
        {
            for( int i= 0; i<5;i++)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                Log.e("Detail", id+"");
            }
        }


        Log.e( " End for",runnableTest+"");   }





}
