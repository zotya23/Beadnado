package com.geeksforgeeks.firebaseuserauthentication;

//import android.support.v7.app.AppCompatActivity;
import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    //private static final int REQUEST_CODE = 1;


    private static final String[] STORAGE_PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private static final String[] CALL_PERMISSIONS = {Manifest.permission.CALL_PHONE,
    };




    Button b;
    Button c;

    private TextView geeksforgeeks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyPermissions();



        //initialising all views through id defined above
        geeksforgeeks = findViewById(R.id.gfg);
        //geeksforgeeks.setText("GeeksForGeeks(Firebase Authentication)");

        b = (Button)findViewById(R.id.android1);

        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);

                                     b.startAnimation(animation);

                                 }
                             });




        c = (Button) findViewById(R.id.android2);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.lefttoright);

                c.startAnimation(animation);

            }
        });


    }

    private void verifyPermissions(){
        Log.d(TAG, "verifyPermissions: Checking Permissions.");

        int permissionCallPhone = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
        int permissionExternalMemory = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permissionCallPhone != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }

        if(permissionExternalMemory != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    STORAGE_PERMISSIONS,
                    1

            );

        }
    }


}