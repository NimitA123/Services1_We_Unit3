package com.example.bound_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnPlay;
    private Button mBtnPause;
    private Button mBtnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnPlay = findViewById(R.id.btnPlay);
        mBtnPause = findViewById(R.id.btnStop);
        mBtnStop = findViewById(R.id.btnStop);
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(musicService!= null){
                    musicService.play();
                }
            }
        });
        startService();

    }
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.ServiceBinder serviceBinder = (MusicService.ServiceBinder) binder;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    private void startService(){
        Intent intent = new Intent(MainActivity.this, MusicService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

}