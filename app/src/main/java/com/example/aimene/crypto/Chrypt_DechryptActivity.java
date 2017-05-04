package com.example.aimene.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Chrypt_DechryptActivity extends AppCompatActivity {

      /////////////////////
     //----Attribute----//
    /////////////////////
    TextView type_from;
    TextView type_to;
    TextView text_from;
    TextView text_to;

    Intent getData;

    String name,key,text,action;

    // Life cycle activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrypto_result);

        // Initialisation
        init();

    }


    // Methodes


    /* Initialisation */
    private void init() {

        /* Preview info */
        getData = getIntent();
        name = getData.getExtras().get("name").toString();
        key = getData.getExtras().get("key").toString();
        text = getData.getExtras().get("text").toString();
        action = getData.getExtras().get("action").toString();

        /* Match layout */
        type_from = (TextView) findViewById(R.id.label1);
        type_to = (TextView) findViewById(R.id.label2);

        text_from = (TextView) findViewById(R.id.txt1);
        text_to = (TextView) findViewById(R.id.txt2);

        /* Set value */

        text_from .setText(text);

        if(action.equals("Chrypt")){
            /* chrypting */
            chrypt();
        }
        else{
            /* de_chrypting */
            de_chrypt();
        }


    }



      ////////////////////
     //----Methodes----//
    ////////////////////

    /* Chrypting */
    private void chrypt() {
        type_from.setText("Plain_text");
        type_to.setText("Chrypted_text");
        Chrypto box = new Chrypto(name);
        text_to.setText(box.chrypt(text,key));
    }

    /* De_chrypting */
    private void de_chrypt() {
        type_from.setText("Chrypted_text");
        type_to.setText("Plain_text");
        Chrypto box = new Chrypto(name);
        text_to.setText(box.de_chrypt(text,key));
    }
}
