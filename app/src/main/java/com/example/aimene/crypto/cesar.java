package com.example.aimene.crypto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                cephirText.setText(crypte(clairText.getText().toString()));
                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
            break;
            case R.id.btnreset:
                clairText.setText("");
                scale.setText("");
                cephirText.setText("");
                decryptedText.setText("");
                break;
        }
    }

    private String crypte(String a) {
        String crypted = "";
        for (int i = 0, len = a.length(), buffer = 0; i < len; i++) {
            buffer = ((int) a.charAt(i)) + 3;
            crypted = crypted + (char)(buffer);
        }
        return crypted;
    }
}
