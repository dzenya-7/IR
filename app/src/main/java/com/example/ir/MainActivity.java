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
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {


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
        }
        else {
            Toast.makeText(this, "Предоставьте разрешение!", Toast.LENGTH_LONG).show();
            requestContactPermission();
        }
    }

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