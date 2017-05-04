package com.example.aimene.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

      /////////////////////
     //----Attribute----//
    /////////////////////
    Button classical;
    Button modern;


    // Activity life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation
        init();

    }



      ////////////////////
     //----Methodes----//
    ////////////////////


    /* Initialisation */
    private void init() {
        // Match layout
        classical = (Button) findViewById(R.id.classicCrypto);
        modern = (Button) findViewById(R.id.modernCrypto);

        // OnClick Listener
        classical.setOnClickListener(this);
        modern.setOnClickListener(this);
    }


    /* Onclick Listener */
    @Override
    public void onClick(View v) {

        Intent familly_box = new Intent(this, FamillyBoxActivity.class);

        switch (v.getId()) {
            case R.id.classicCrypto:
                familly_box.putExtra("familly","Classic");
                break;
            case R.id.modernCrypto:
                familly_box.putExtra("familly","Modern");
                break;

            default:
                return ;
        }

        startActivity(familly_box);
    }
}
