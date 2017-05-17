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

import java.util.concurrent.ExecutionException;

public class GetData extends AppCompatActivity  implements View.OnClickListener{

      /////////////////////
     //----Attribute----//
    /////////////////////
    TextView chrypto_name;
    TextView tkey;

    EditText text;
    EditText key;


    Button go_result;
    Button reset;
    Button get_key;
    Button help;


    RadioButton chrypt;
    RadioButton de_chrypt;

    Intent familly_box;
    String name;

    // Life cycle activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

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
        tkey = (TextView) findViewById(R.id.tkey);

        key = (EditText) findViewById(R.id.key);
        text = (EditText) findViewById(R.id.text);

        go_result = (Button) findViewById(R.id.result);
        reset = (Button) findViewById(R.id.btnreset);
        get_key = (Button) findViewById(R.id.get_key);
        help = (Button) findViewById(R.id.help);

        name = familly_box.getExtras().get("name").toString();

        if( !name.equals("Rsa") )
            get_key.setVisibility(View.GONE);
        else {
            tkey.setVisibility(View.VISIBLE);
            key.setVisibility(View.GONE);
        }
        get_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String a = new Call_server_asynch().execute(name, "get_key").get();
                    if ( !name.equals("Rsa") ){
                        key.setText(a);
                    }
                    else
                        tkey.setText(a);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        if( !name.equals("Rsa") )
            get_key.setVisibility(View.GONE);

        chrypt = (RadioButton) findViewById(R.id.chrypt);
        de_chrypt = (RadioButton) findViewById(R.id.de_chrypt);

        /* Set value */
        chrypto_name.setText(familly_box.getExtras().get("name").toString());


        /* Listeners */
        go_result.setOnClickListener(this);
        reset.setOnClickListener(this);
        help.setOnClickListener(this);
    }


    /* OnClickListener */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.result:
                if(!text.getText().toString().equals("")){
                    if (name.equals("Cezar") && is_ok_cezar()){
                        go_cript();
                    }
                    else
                        if (name.equals("Vigener") && is_ok_Vigener()){
                            go_cript();
                        }

                }
                else
                    Toast.makeText(this,"Incorrect or empty value Click Help for more Info",Toast.LENGTH_SHORT).show();
            break;

            case R.id.btnreset:
                text.setText("");
                if(!name.equals("Rsa"))
                    key.setText("");
                else
                    tkey.setText("");
                break;
            case R.id.help:
                Intent info = new Intent(this, Help.class);
                info.putExtra("name",name);
                startActivity(info);
                break;
        }



}

    /* VAlidation */
    public boolean is_ok_cezar() {
        String k = key.getText().toString();
        boolean v = false;
        if (name.equals("Cezar")){
                if (k.length() == 1) {
                    if (
                            ((k.charAt(0) >= 'a' && k.charAt(0) <= 'z') || (k.charAt(0) >= 'A' && k.charAt(0) <= 'Z'))
                            || (k.charAt(0) >= '0' && k.charAt(0) <= '9')
                            )
                        v = true;

                } else if (k.length() == 2) {
                    if ((k.charAt(0) >= '1' && k.charAt(0) <= '2') && (k.charAt(0) >= '0' && k.charAt(0) <= '5'))
                        v = true;
                }
            }
        if (!v)
            Toast.makeText(this,"Incorrect or empty value Click Help for more Info",Toast.LENGTH_SHORT).show();;

        return v;
    }

    public boolean is_ok_Vigener() {
        String k = key.getText().toString();
        boolean v = false;

        int counter = 0;
        while (counter < k.length() &&  (
                ((k.charAt(counter)>='A' && k.charAt(counter)<='Z') ) ||(k.charAt(counter)>='a' && k.charAt(counter)<='z') ) ) {
            counter ++;
        }
        if (counter >= k.length() )
            v = true;

        if (!v)
            Toast.makeText(this,"Incorrect or empty value Click Help for more Info",Toast.LENGTH_SHORT).show();
        return v;
    }

    /* Start next activity */
    private void go_cript() {
        Intent result = new Intent(this,Cript_DecriptActivity.class);
        if ( !name.equals("Rsa"))
            result.putExtra("key",key.getText().toString());
        else
            result.putExtra("key",tkey.getText().toString());

        result.putExtra("name",chrypto_name.getText().toString());
        result.putExtra("text",text.getText().toString());

        if (chrypt.isChecked())
            result.putExtra("action","Chrypt");
        else
            result.putExtra("action","DeChrypt");

        startActivity(result);

    }
}