package com.example.services1_we_unit3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class MyService extends Service {
    private String name = "";
    public MyService() {
    }
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            saveToFile();
        }
    };

    private void saveToFile() {
        /*To save something in file all of us create directly*/
        /*Internal Storage <--- getFileDir() only app can access Example SSD card
        * External Storage<---- we can access it like whatsapp photo*/
        try{
           File directory  = new File(getFilesDir()+File.separator+"NameFolder");
           directory.mkdir();
           if(!directory.exists()){
               directory.mkdir() ;//mkdir() create a directory / folder
           }
           /*Create a file inside a directory*/
            File file = new File(directory, "name.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter write = new OutputStreamWriter(fileOutputStream);
            write.append(name+"/n");
            write.close();
            /*file is being successfully created*/
            Intent intent = new Intent("com.xyz.service");
            intent.putExtra("data", "write Done");
            sendBroadcast(intent);
        }
        catch (Exception e){

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotificationAndStartForeGround();
        /*If want to show notification once than only call from onCrete OtherWise call from
        * onStartCommand method*/
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent!= null){
            name = intent.getStringExtra("name");
        }
        launchBackgroundThread();

        return super.onStartCommand(intent, flags, startId);

    }

    private void launchBackgroundThread() {
        Thread thread = new Thread(task);
        thread.start();
    }

    private void showNotificationAndStartForeGround() {
        createChannel();

        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("Service is running : yaay")
                .setContentText("name is android")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = null;
        notification = notificationBuilder.build();
        startForeground(1, notification);
    }


    /*
Create noticiation channel if OS version is greater than or eqaul to Oreo
*/
    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "Nimit", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }
}