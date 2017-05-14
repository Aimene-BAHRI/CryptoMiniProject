package com.example.aimene.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FamillyBoxActivity extends AppCompatActivity implements View.OnClickListener{

      /////////////////////
     //----Attribute----//
    /////////////////////
    TextView familly;
    Button chrypto_type1;
    Button chrypto_type2;
    Intent main_activity;


    // Life cycle Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familly_box);


        // Initialisation
        init();

    }



    // Methodes

    /* Initialisation */
    private void init() {

        /* Preview info */
        main_activity = getIntent();

        /* Match layout */
        familly = (TextView) findViewById(R.id.familly);
        chrypto_type1 = (Button) findViewById(R.id.type1);
        chrypto_type2 = (Button) findViewById(R.id.type2);

        /* Set layout */
        familly.setText(main_activity.getExtras().get("familly").toString());
        if(main_activity.getExtras().get("familly").toString().equals("Classic")){
            chrypto_type1.setText("Cezar");
            chrypto_type2.setText("Vigener");
        }
        else {
            chrypto_type1.setText("Rsa");
            chrypto_type2.setText("Elgamel");
        }

        /* Set listener */
        chrypto_type1.setOnClickListener(this);
        chrypto_type2.setOnClickListener(this);

    }


    /* Onclick Listener */
    @Override
    public void onClick(View v) {

        Intent chrypting = new Intent(this, GetData.class);

        switch (v.getId()) {
            case R.id.type1:
                chrypting.putExtra("name",chrypto_type1.getText().toString());
                break;
            case R.id.type2:
                chrypting.putExtra("name",chrypto_type2.getText().toString());
                break;
            default:
                return ;
        }
        startActivity(chrypting);
    }
}
