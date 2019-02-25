package com.amina.facturation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AffecterFacturation extends AppCompatActivity {
    TextView txtNaturePaiement;
    Button btnEnvoyer;
    EditText edtNetaPayer,edtNomProduit,edtMontant,edtRemise;
    String naturePaiement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affecter_facturation);
        txtNaturePaiement=findViewById(R.id.txtNatureDePaiement);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            naturePaiement = data.getString("naturePaiement");

        }

        txtNaturePaiement.setText("Facture au "+ naturePaiement);
    }
}
