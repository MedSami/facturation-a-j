package com.amina.facturation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Facturation extends AppCompatActivity {
Button btnCredit,btnComptant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturation);
        btnComptant=findViewById(R.id.btnFComptant);
        btnCredit=findViewById(R.id.btnFCredit);

        btnComptant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Facturation.this,AffecterFacturation.class);
                i.putExtra("naturePaiement","comptant");
                startActivity(i);
            }
        });

        btnCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Facturation.this,AffecterFacturation.class);
                i.putExtra("naturePaiement","credit");
                startActivity(i);
            }
        });

    }
}
