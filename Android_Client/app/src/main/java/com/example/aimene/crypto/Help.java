package com.example.aimene.crypto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends Activity {

    // Attribute

    TextView name;
    TextView helpt;

    String helps[];
    Intent get_data;


    // Activity life cycle


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        /* Init component */
        init();
    }


    // Methodes
    private void init() {

        /* preview data */
        get_data = getIntent();

        /* Match layout */
        name = (TextView) findViewById(R.id.name);
        helpt = (TextView) findViewById(R.id.helpt);

        /* Set layout */
        name.setText(get_data.getExtras().get("name").toString());
        set_help_data();
        switch (name.getText().toString()){
            case "Cezar":
                helpt.setText(helps[0]);
                break;

            case "Vigener":
                helpt.setText(helps[1]);
                break;

            case "Rsa":
                helpt.setText(helps[2]);
                break;

            case "Elgamel":
                helpt.setText(helps[3]);
                break;
        }
    }

    /* Set the help array */
    private void set_help_data() {
        helps = new String[4];

        String empty = " ** Empty Key OR Message are not allowed !\n\n";

        helps[0] = empty + "** You can insert an alpha [a-zA-Z] OR numeric [0-25] Key\n\n" +
                "of lenght <<1>> for alpha and length \n\n\n exemple : R (or 17)";
        helps[1] = empty + "** You can insert an alphabetic Word as a key\n\n\n" +
                "exemple: OreO ;";
        helps[2] = empty + "** You Need to request your own Key \n\n\n" +
                "it's look like : --BEGIN RSA PRIV ";
        helps[3] = empty + "";
    }
}
