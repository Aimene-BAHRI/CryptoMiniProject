package com.example.aimene.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;

public class classicalCrypto extends AppCompatActivity implements OnClickListener{
    Button cesar;
    Button viginer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical_crypto);
        cesar = (Button) findViewById(R.id.cesar);
        cesar.setOnClickListener(this);
        viginer = (Button) findViewById(R.id.viginer);
        viginer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cesar:
                Intent intent = new Intent(this, cesar.class);
                startActivity(intent);
                break;
            case R.id.viginer:
                Intent intent2 = new Intent(this, viginer.class);
                startActivity(intent2);
                break;
        }
    }
}
