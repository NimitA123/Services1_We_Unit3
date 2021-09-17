package com.example.intentservice_we_unit3;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class DownloadService extends IntentService {



    public DownloadService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
       downloadFile();
    }

    private void downloadFile() {
        try{
          File directory = new File(getFilesDir()+ File.separator+"vogella");
          if(!directory.exists()){
              directory.mkdir();
          }
          File file = new File(directory, "vogella.html");
          if(!file.exists()){
              file.createNewFile();
          }
         URL url = new URL("https://www.vogella.com/index.html");
          InputStream inputStream = url.openConnection().getInputStream();//data from server a stream

            InputStreamReader reader = new InputStreamReader(inputStream);//reading from the stream
            FileOutputStream writer = new FileOutputStream(file, true);
            int data = reader.read();
           while(data != -1){
                char ch = (char) data;
                writer.write(ch);
                data= reader.read();
            }
           // Read from file
            FileInputStream fileInputStream = new FileInputStream(file);
           int fileData = fileInputStream.read();
           StringBuffer stringBuffer = new StringBuffer();
           while(fileData != -1){
               char ch = (char) fileData;
               stringBuffer = stringBuffer.append(ch);
               fileData = fileInputStream.read();
           }
        }
        catch (Exception e){

        }
    }

}