package com.example.service_musicplayer_you_unit3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MusicPlayerThread extends Service {
    private MediaPlayer mediaPlayer;
    private static String TAG = MediaPlayer.class.getName();
    public MusicPlayerThread() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "OnCreate");
        mediaPlayer = MediaPlayer.create(this, R.raw.shape);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // mediaPlayer = MediaPlayer.create(this, R.raw.shape);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          //  startMusic();
            showNotificationAndStartForeGround();
            startMusic();

        }
    //    startMusic();
        Log.d(TAG, "OnStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    private void startMusic() {
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "OnDestroy");
        super.onDestroy();
        mediaPlayer.stop();
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private void showNotificationAndStartForeGround() {
        String NOTIFICATION_CHANNEL_ID = "lloyd";
        String channelName = "Background Service";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setContentTitle("App is running in background")
                .setContentText("Hey music is playing")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        startForeground(2, notification);
    }
}