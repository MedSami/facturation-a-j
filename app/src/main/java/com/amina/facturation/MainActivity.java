package com.amina.facturation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edtPseudo,edtPassword;
Button btnEntrer,btnInscrire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPassword=findViewById(R.id.edtPassword);
        edtPseudo=findViewById(R.id.edtPseudo);
        btnEntrer=findViewById(R.id.btnLogin);
        btnInscrire=findViewById(R.id.btnInscrit);
    }
}
