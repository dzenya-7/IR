package com.example.ir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddRemote extends AppCompatActivity {

    EditText editFrequency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remote);
        editFrequency = findViewById(R.id.edit_frequency);
        EditText editDeviceName = findViewById(R.id.edit_device_name);

    }

    public void addRemote(View view) {
        String frequency = editFrequency.getText().toString();
    }
}