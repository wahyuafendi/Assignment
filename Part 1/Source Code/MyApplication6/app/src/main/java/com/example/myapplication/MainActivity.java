package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Helper.MyService;
import com.example.myapplication.Helper.MyServiceCallback;


public class MainActivity extends AppCompatActivity implements MyServiceCallback {


    private MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of the service
        myService = new MyService();

        // Set the activity as the callback listener
        myService.setCallback(this);

        // Start the service
        startService(new Intent(MainActivity.this, MyService.class));

        // Button click to trigger service button click
        Button sendService = findViewById(R.id.Btn_service);
        sendService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Trigger button click in service
                myService.buttonClicked();
            }
        });
    }

    // Implementation of callback method to receive data from service
    @Override
    public void onDataReceived(String data) {
        // Display data received from service
        Toast.makeText(this,  data, Toast.LENGTH_SHORT).show();
    }

}