package com.example.ir;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    List<Controller> controllerList = new ArrayList();
    ListView controllerListView;
    TextView textView;
    //Permission
    private static final int PERMISSIONS_REQUEST_TRANSMIT_IR = 1;
    private boolean hasContactPermissin() {

        return ContextCompat.checkSelfPermission(this, Manifest.permission.TRANSMIT_IR) == PackageManager.PERMISSION_GRANTED;

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onRequestPermRes(int requestCode, @NonNull String[] permission, @NonNull int[] grantRes) {

        if (requestCode == PERMISSIONS_REQUEST_TRANSMIT_IR) {

            if (grantRes[0] != PackageManager.PERMISSION_GRANTED) {

                makeText(this, " Дай разрешение!", Toast.LENGTH_LONG).show();

            }

        }

        super.onRequestPermissionsResult(requestCode, permission, grantRes);

    }
    private void requestContactPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.TRANSMIT_IR},
                    PERMISSIONS_REQUEST_TRANSMIT_IR);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(hasContactPermissin()){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            controllerListView = findViewById(R.id.controller_list_view);
            String[] array= {};
            //TODO make get from DB method
            if(array.length==0){
                textView =  findViewById(R.id.text2);
                textView.setText("Array is empty");
            }
            else{
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
                controllerListView.setAdapter(adapter);
                controllerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                            long id) {
                        //TODO make method for item click

                        Intent intent = new Intent(getApplicationContext(),RemoteActivity.class);
                        intent.putExtra("id_controller",position);
                        startActivity(intent);
                    }
                });
            }

        }
        else {
            Toast.makeText(this, "Предоставьте разрешение!", Toast.LENGTH_LONG).show();
            requestContactPermission();
        }

    }

    public void toTransmitActivity(View view){
        Intent intent= new Intent(this,RemoteActivity.class);
        startActivity(intent);
    }
    //Buttons
    public void toAddActivity(View view){
        Intent intent= new Intent(this,AddRemote.class);
        startActivity(intent);
    }
    public void click(View view) {
        try {
            TransmitFacade.transmit(this,10,new int[]{ 1, 105, 5, 1, 75, 1095, 20, 60, 20, 140, 15, 2500, 80, 1 });
            makeText(this, "Transmit information", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}