package com.example.aimene.crypto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class viginer extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_viginer);
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
                for (int i = 0,let = clairText.getText().toString().length(); i < let; i++) {
                    clairText.setText((""+clairText.getText().toString().charAt(i)+scale).charAt(i));
                    cephirText.setText((""+clairText.getText().toString().charAt(i)+scale).charAt(i));
                    Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
