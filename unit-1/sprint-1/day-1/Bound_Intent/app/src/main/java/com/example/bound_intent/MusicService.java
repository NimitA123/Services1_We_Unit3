package com.example.bound_intent;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
    public void play(){

    }
    public void stop(){

    }
    public void pause(){

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return  new ServiceBinder();
    }
    public class ServiceBinder extends Binder {
        public MusicService getMusicService(){
            return MusicService.this; // return Service object
        }
    }
}