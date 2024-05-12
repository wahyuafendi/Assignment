package com.example.myapplication.Helper;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MyServiceCallback callback;

    // Method to set the callback
    public void setCallback(MyServiceCallback callback) {
        this.callback = callback;
    }

    // Method to send data to the activity through the callback
    private void sendDataToActivity(String data) {
        if (callback != null) {
            callback.onDataReceived(data);
        }
    }

    // Method to simulate button click in the service
    public void buttonClicked() {
        // Simulate data
        String data = "Data Ini Diambil Dari Services";
        // Send data to activity
        sendDataToActivity(data);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
