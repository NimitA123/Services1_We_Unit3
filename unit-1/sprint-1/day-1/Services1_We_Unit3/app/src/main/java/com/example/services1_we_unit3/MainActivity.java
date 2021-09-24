package com.example.services1_we_unit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*Service is a Android Component The Main Difference between a Service and Thread is Clicking
    * the back button Thread will Destroy while Service will not destroy by Default service will run
    * in Main UI and Service will not Stop automatically u Should Stop while using StopService() method
    **/
    /*** Service is a Special Class that will keep on Running even if your app main thread is killed****/
    private EditText mEtName;
    private Button mBtnSave;
    private BroadcastReceiver serviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        IntentFilter intentFilter = new IntentFilter("com.xyz.Service");
        registerReceiver(serviceReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(serviceReceiver);
    }

    private void initView() {
         mEtName = findViewById(R.id.etName);
         mBtnSave = findViewById(R.id.btnSave);
         mBtnSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, MyService.class);
               intent.putExtra("name", mEtName.getText().toString());
               startService(intent);
           }
       });
    }
}