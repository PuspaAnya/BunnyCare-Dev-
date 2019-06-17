package com.example.tamarapuspa.bunny1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button konsul, merawat, jenis, tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konsul = findViewById(R.id.konsul);
        konsul.setOnClickListener(this);

        merawat = findViewById(R.id.merawat);
        merawat.setOnClickListener(this);

        jenis = findViewById(R.id.jenis);
        jenis.setOnClickListener(this);

        tentang = findViewById(R.id.tentang);
        tentang.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.konsul:
                Intent moveIntent1 = new Intent(MainActivity.this, konsultasi.class);
                startActivity(moveIntent1);
                break;
            case R.id.merawat:
                Intent moveIntent2 = new Intent(MainActivity.this, merawat.class);
                startActivity(moveIntent2);
                break;
            case R.id.jenis:
                Intent moveIntent3 = new Intent(MainActivity.this, jenis.class);
                startActivity(moveIntent3);
                break;
            case R.id.tentang:
                Intent moveIntent4 = new Intent(MainActivity.this, tentang.class);
                startActivity(moveIntent4);
                break;
        }
    }
}
