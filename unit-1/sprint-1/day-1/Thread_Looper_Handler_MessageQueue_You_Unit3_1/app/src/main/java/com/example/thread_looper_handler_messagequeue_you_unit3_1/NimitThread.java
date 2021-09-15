package com.example.thread_looper_handler_messagequeue_you_unit3_1;

import android.os.Handler;
import android.os.Looper;

public class NimitThread  extends Thread{
    private Handler handler1;
    @Override
    public void run() {
        super.run();
        Looper.prepare();//this will give u message queue
        handler1 = new Handler(Looper.myLooper());// add the message to the queue
        Looper.loop();// process queue
    }
    public void addTaskToMessageQueue(Runnable task){
        if(handler1!= null){
            handler1.post(task);
        }
    }
}
