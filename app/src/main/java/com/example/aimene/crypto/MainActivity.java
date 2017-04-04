package com.example.aimene.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button classical;
    Button modern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classical = (Button) findViewById(R.id.classicCrypto);
        modern = (Button) findViewById(R.id.modernCrypto);

        classical.setOnClickListener(this);
        modern.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.classicCrypto:
                Intent intent = new Intent(this, classicalCrypto.class);
                startActivity(intent);
                break;
            case R.id.modernCrypto:
                Intent intent1 = new Intent(this, modernCrypto.class);
                startActivity(intent1);
                break;
            default:
                return ;
        }
    }
}
