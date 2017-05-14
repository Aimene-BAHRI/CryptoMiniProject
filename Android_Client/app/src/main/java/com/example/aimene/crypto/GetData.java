package com.example.aimene.crypto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class GetData extends AppCompatActivity  implements View.OnClickListener{

      /////////////////////
     //----Attribute----//
    /////////////////////
    TextView chrypto_name;

    EditText text;
    EditText key;

    Button go_result;
    Button reset;

    RadioButton chrypt;
    RadioButton de_chrypt;

    Intent familly_box;


    // Life cycle activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chripting);

        // Initialisation
        init();
    }



      ////////////////////
     //----Methodes----//
    ////////////////////

    /* Initialisation */
    private void init() {

        /* preview info */
        familly_box = getIntent();

        /* Match layout */
        chrypto_name = (TextView) findViewById(R.id.chtypto_name);

        key = (EditText) findViewById(R.id.key);
        text = (EditText) findViewById(R.id.text);

        go_result = (Button) findViewById(R.id.result);
        reset = (Button) findViewById(R.id.btnreset);

        chrypt = (RadioButton) findViewById(R.id.chrypt);
        de_chrypt = (RadioButton) findViewById(R.id.de_chrypt);

        /* Set value */
        chrypto_name.setText(familly_box.getExtras().get("name").toString());

        if(familly_box.getExtras().get("name").toString().equals("Rsa")){
            key.setText("none");
            key.setVisibility(View.GONE);
        }
        /* Listeners */
        go_result.setOnClickListener(this);
        reset.setOnClickListener(this);
    }


    /* OnClickListener */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.result:
                if (!text.getText().toString().equals("") &&
                        !key.getText().toString().equals("")){
                    Intent result = new Intent(this,Cript_DecriptActivity.class);

                    result.putExtra("name",chrypto_name.getText().toString());
                    result.putExtra("key",key.getText().toString());
                    result.putExtra("text",text.getText().toString());

                    if (chrypt.isChecked())
                        result.putExtra("action","Chrypt");
                    else
                        result.putExtra("action","DeChrypt");

                    startActivity(result);

                }
                else Toast.makeText(this,"Incorrect or empty value",Toast.LENGTH_SHORT).show();
            break;

            case R.id.btnreset:
                text.setText("");
                key.setText("");
                break;
        }
    }


}