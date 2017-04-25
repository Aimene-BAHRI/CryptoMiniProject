package com.example.aimene.crypto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cesar extends AppCompatActivity  implements View.OnClickListener{
    EditText clairText;
    EditText scale;
    EditText cephirText;
    EditText decryptedText;

    Button crypted;
    Button decrypted;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesar);
        clairText = (EditText) findViewById(R.id.clairText);
        scale = (EditText) findViewById(R.id.scale);
        cephirText = (EditText) findViewById(R.id.cephirText);
        decryptedText = (EditText) findViewById(R.id.decrypted);

        crypted = (Button) findViewById(R.id.btnCrypted);
        crypted.setOnClickListener(this);
        decrypted = (Button) findViewById(R.id.btndecrypted);
        decrypted.setOnClickListener(this);
        reset = (Button) findViewById(R.id.btnreset);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCrypted:
                int a = Integer.parseInt(scale.getText().toString());
                cephirText.setText(crypte(clairText.getText().toString(), a));
            break;
            case R.id.btndecrypted:
                int b = Integer.parseInt(scale.getText().toString());
                decryptedText.setText(decrypte(cephirText.getText().toString(), b));
                break;
            case R.id.btnreset:
                clairText.setText("");
                scale.setText("");
                cephirText.setText("");
                decryptedText.setText("");
                break;
        }
    }

    private String crypte(String a, int b) {
        String crypted = "";
        for (int i = 0, len = a.length(), buffer = 0; i < len; i++) {
            buffer = ((int) a.charAt(i)) + b;
            crypted = crypted + (char)(buffer);
        }
        return crypted;
    }
    private String decrypte(String a, int b) {
        String decrypted = "";
        for (int i = 0, len = a.length(), buffer = 0; i < len; i++) {
            buffer = ((int) a.charAt(i)) - b;
            decrypted = decrypted + (char)(buffer);
        }
        return decrypted;
    }
}