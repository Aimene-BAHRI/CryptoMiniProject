package com.example.aimene.crypto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
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
                int let = clairText.getText().toString().length();
                for (int i = 1; i < let; i++) {
                    cephirText.setText(clairText.getText().toString().length());
                }
                Toast.makeText(this, cephirText.getText(), Toast.LENGTH_SHORT).show();
            break;
        }
    }
}
