package com.example.ir;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RemoteActivity extends AppCompatActivity {

    public Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        //TODO get controller from DB

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        // controller =


    }

    public void transmit(String str){
        int[] pattern;

        //TransmitFacade(controller.frequency,pattern)
    }
}