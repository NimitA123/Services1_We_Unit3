package com.example.thread_looper_handler_messagequeue_you_unit3_1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button btn;
    private TextView tv;
    private NimitThread workerThread;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                for(int i = 0;   i <= 10;   i++) {
                    Log.d("Nimit", "The values of i is "+i);
                  //tv.setText("The Process is Completed "+(i*10));
                   progressBar.setProgress(i);
                //   tv.setText("The Process is Completed "+(i*10));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
  /*We can perform any kind of operation inside threads except updating the UI elements. To update
   a UI element from a thread, we need to use either the handler or the runOnUIThread method.*/
    /*Message Queue has a list of tasks that has been executed in a certain tread*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        btn = findViewById(R.id.btnShow);
        progressBar = findViewById(R.id.pBar);
        tv = findViewById(R.id.tView);
        workerThread = new NimitThread();
        workerThread.start();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              workerThread.addTaskToMessageQueue(runnable);
            }
        });

    }


}