package com.example.ir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddRemote extends AppCompatActivity {

    EditText editFrequency;
    EditText editDeviceName;
    EditText editTopCode;
    EditText editBottomCode;
    EditText editLeftCode;
    EditText editRightCode;
    EditText editPlusCode;
    EditText editMinusCode;
    EditText editOkCode;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remote);
        findView();
    }

    public void addRemote(View view) {
        addController();
        //TODO make method for insert controller in DB
    }

    public  void addController(){
        int frequency = Integer.parseInt(editFrequency.getText().toString());
        String device_name = editDeviceName.getText().toString();
        String topButton = editTopCode.getText().toString();
        String bottomButton = editBottomCode.getText().toString();
        String leftButton = editLeftCode.getText().toString();
        String rightButton = editRightCode.getText().toString();
        String plusButton = editPlusCode.getText().toString();
        String minusButton = editMinusCode.getText().toString();
        String okButton = editOkCode.getText().toString();
        controller = new Controller(frequency,device_name,topButton,bottomButton,leftButton,rightButton,plusButton,minusButton,okButton);
    }
    public  void findView(){
        editFrequency = findViewById(R.id.edit_frequency);
        editDeviceName = findViewById(R.id.edit_device_name);
        editTopCode = findViewById(R.id.edit_top_button);
        editBottomCode = findViewById(R.id.edit_bottom_button);
        editLeftCode = findViewById(R.id.edit_left_button);
        editRightCode = findViewById(R.id.edit_right_button);
        editMinusCode = findViewById(R.id.edit_minus_button);
        editPlusCode = findViewById(R.id.edit_plus_button);
        editOkCode = findViewById(R.id.edit_ok_button);
    }
}