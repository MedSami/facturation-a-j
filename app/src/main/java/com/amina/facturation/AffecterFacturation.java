package com.amina.facturation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.amina.facturation.API.ApiRequest;
import com.amina.facturation.API.RetrofitServer;
import com.amina.facturation.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AffecterFacturation extends AppCompatActivity {
    TextView txtNaturePaiement;
    Button btnEnvoyer;
    EditText edtNetaPayer,edtNomProduit,edtMontant,edtRemise,edtClient;
    RadioButton rdbPublic,rdbAbonne;
    String naturePaiement,clientpublic="0",clientabonne="0", NF,NumFacture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affecter_facturation);
        txtNaturePaiement=findViewById(R.id.txtNatureDePaiement);

        btnEnvoyer=findViewById(R.id.btnValider);
        edtClient=findViewById(R.id.edtrdbClient);
        edtNetaPayer=findViewById(R.id.edtNetAPayer);
        edtNomProduit=findViewById(R.id.edtNomProduit);
        edtMontant=findViewById(R.id.edtMontant);
        edtRemise=findViewById(R.id.edtRemise);
        rdbPublic=findViewById(R.id.rdbPublic);
        rdbAbonne=findViewById(R.id.rdbAbonne);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            naturePaiement = data.getString("naturePaiement");

        }

        txtNaturePaiement.setText("Facture au "+ naturePaiement);

        ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
        //Instance Call Methode
        Call<ResponseDataModel> Numero_Facture=api.NumeroFacture();
        Numero_Facture.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                if (response.isSuccessful()){
                   NF=""+response.body().getResult().get(0).getNumero();
                    NumFacture= "F"+ (Integer.parseInt(NF)+1);

                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(AffecterFacturation.this, "Erreur de calcul Numero Facture", Toast.LENGTH_SHORT).show();
            }
        });

    btnEnvoyer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(edtMontant.getText().toString().equals("")){
                Toast.makeText(AffecterFacturation.this, "Saisir Montant SVP", Toast.LENGTH_SHORT).show();
            }else if(edtRemise.getText().toString().equals("")){
                Toast.makeText(AffecterFacturation.this, "Saisir Remise SVP", Toast.LENGTH_SHORT).show();
            }else if (edtNomProduit.getText().toString().equals("")){
                Toast.makeText(AffecterFacturation.this, "Saisir Nom Produit SVP", Toast.LENGTH_SHORT).show();
            }else if(!rdbPublic.isChecked() && !rdbAbonne.isChecked()){
                Toast.makeText(AffecterFacturation.this, "coché type client SVP", Toast.LENGTH_SHORT).show();
            }else if(rdbPublic.isChecked() && edtClient.getText().toString().equals("")){
                Toast.makeText(AffecterFacturation.this, "Saisir Nom entreprise Public SVP", Toast.LENGTH_SHORT).show();
            }else if(rdbAbonne.isChecked() && edtClient.getText().toString().equals("")){
                Toast.makeText(AffecterFacturation.this, "Saisir Nom entreprise Public SVP", Toast.LENGTH_SHORT).show();
                }else {

                ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                //Instance Call Methode
                Call<ResponseDataModel> facturation=api.Facturation(edtMontant.getText().toString(),
                        edtNetaPayer.getText().toString(),
                        naturePaiement,clientpublic,clientabonne,
                        edtNomProduit.getText().toString(),NumFacture);
            facturation.enqueue(new Callback<ResponseDataModel>() {
                @Override
                public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                    Toast.makeText(AffecterFacturation.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                    Toast.makeText(AffecterFacturation.this, "Problem de connexion", Toast.LENGTH_SHORT).show();
                }
            });

            }
        }
    });


    }

    public void RadioPublic(View view) {
        edtClient.setVisibility(View.VISIBLE);
        edtClient.setHint(R.string.hint_public);
        clientpublic="1";
        clientabonne="0";

    }

    public void RadioAbonne(View view) {
        edtClient.setVisibility(View.VISIBLE);
        edtClient.setHint(R.string.hint_abonne);
        clientabonne="1";
        clientpublic="0";
    }





}
