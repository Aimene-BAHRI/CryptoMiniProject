package com.example.aimene.crypto;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Cript_DecriptActivity extends AppCompatActivity {

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



      ////////////////////
     //----Methodes----//
    ////////////////////


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

        text_to.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(getApplicationContext(),"Copy",Toast.LENGTH_SHORT).show();

                // Gets a handle to the clipboard service.
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                // Creates a new text clip to put on the clipboard
                ClipData clip = ClipData.newPlainText("simple text", text_to.getText().toString());
                // Set the clipboard's primary clip.
                clipboard.setText(clip.getItemAt(0).getText());

                return false;
            }
        });

        /* Set value */
        text_from .setText(text);

        if(action.equals("Chrypt")){
            /* cripting */
            cript();
        }
        else{
            /* de_cripting */
            de_cript();
        }

    }


    /* Encripting */
    private void cript() {


        type_from.setText("Plain_text");
        type_to.setText("Cripted_text");
        try {
            String a = new Call_server_asynch().execute(name, "c", text, key).get();
            text_to.setText(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /* Decrypting */
    private void de_cript() {
        type_from.setText("Cripted_text");
        type_to.setText("Plain_text");
        try {
            String a = new Call_server_asynch().execute(name, "d", text, key).get();
            text_to.setText(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
