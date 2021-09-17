package com.example.handlerthread_asynctask_we;

import android.app.Notification;
import android.net.wifi.aware.DiscoverySession;
import android.os.HandlerThread;
import android.os.Message;

import java.util.logging.Handler;


public class WorkerThread extends HandlerThread {
    private Handler mainThreadHandler;

    public WorkerThread(String name, Handler mainThreadHandler) {
        super(name);
        this.mainThreadHandler = mainThreadHandler;
    }


    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress = 0;
        for(int i = 0;  i < 10;   i++){
            try {
                Thread.sleep(2000);
                progress = progress + 10;
                Message message = Message.obtain();
                message.obj = progress;
                message.what= 1;
                mainThreadHandler.sendMessage(message);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}