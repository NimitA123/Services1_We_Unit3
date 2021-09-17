package com.example.handlerthread_asynctask_we;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    private CircularProgressIndicator progressBar;
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper())

    {
        hander
    };




    /*AsyncTask Method
    * 1.onPreExecute if u want to show toast message before downloading   a file in background than
    * use onPreExecute method it is use in main Thread
    * doInBackground
    * if We rotate the Screen the App will Destroy but task is running
    *
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        WorkerThread workerThread =  new WorkerThread("async", mainThreadHandler);
        workerThread.start();
    }
}