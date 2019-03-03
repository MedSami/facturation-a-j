package com.amina.facturation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Facturation extends AppCompatActivity {
Button btnCredit,btnComptant;
String idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturation);
        btnComptant=findViewById(R.id.btnFComptant);
        btnCredit=findViewById(R.id.btnFCredit);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur=data.getString("idUtilisateur");

        }

        btnComptant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Facturation.this,AffecterFacturation.class);
                i.putExtra("naturePaiement","comptant");
                i.putExtra("idUtilisateur",idUtilisateur);
                startActivity(i);
            }
        });

        btnCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Facturation.this,AffecterFacturation.class);
                i.putExtra("naturePaiement","credit");
                i.putExtra("idUtilisateur",idUtilisateur);
                startActivity(i);
            }
        });

    }
}
