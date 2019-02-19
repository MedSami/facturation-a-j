package com.amina.facturation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        btnInscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Inscrire.class);
                startActivity(i);
            }
        });


        btnEntrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
