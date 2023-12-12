package fr.univbrest.p2_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void lancer (View view ) {
        Intent intent = new Intent(this,MonService.class);
        startService(intent);
    }

    public void Arreter (View view ) {
        Intent intent = new Intent(this,MonService.class);
        stopService(intent);
    }

}