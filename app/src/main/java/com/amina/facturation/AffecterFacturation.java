package com.amina.facturation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AffecterFacturation extends AppCompatActivity {

    String naturePaiement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affecter_facturation);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            naturePaiement = data.getString("naturePaiement");

        }
    }
}
