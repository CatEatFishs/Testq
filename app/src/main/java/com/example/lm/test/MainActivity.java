package com.example.lm.test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            return false;
        }
    });
    private Tests tests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tests=new Tests();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Message message=Message.obtain();
                message.obj="message";
                message.what=1;
                tests.handler1.sendMessage(message);

            }
        });
        thread.start();


    }

    public void btn(View view) {
        String s=tests.toString();
        Log.d("TAG","--s--->"+s);
    }
}
class Tests{
    private  String st;
    public  Handler handler1=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.d("TAG","--handleMessage--->"+msg.obj);
            Log.d("TAG","--handleMessage--->"+msg.what);
            st= (String) msg.obj;
            return false;
        }
    });

    @Override
    public String toString() {
       Log.d("TAG","---toString-->"+st);
       return st;
    }
}
