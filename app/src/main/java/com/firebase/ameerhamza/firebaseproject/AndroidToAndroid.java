package com.firebase.ameerhamza.firebaseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pusher.pushnotifications.PushNotifications;

public class AndroidToAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_to_android);
        PushNotifications.start(getApplicationContext(), "ba728af9-e0be-45c5-9ce5-1e714823d89b");
        PushNotifications.subscribe("hello");
    }
}
