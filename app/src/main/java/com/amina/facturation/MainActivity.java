package com.amina.facturation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amina.facturation.API.ApiRequest;
import com.amina.facturation.API.RetrofitServer;
import com.amina.facturation.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        edtPseudo.setText("Amina");
        edtPassword.setText("amina123");
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
                if(edtPseudo.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Remplir Champ Pseudo Svp", Toast.LENGTH_SHORT).show();
                }else if(edtPassword.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Remplir Champ Mot De Passe SVP", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                    //Instance Call Methode
                    Call<ResponseDataModel> Login=api.Login(edtPseudo.getText().toString());
                Login.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {

                        if(response.isSuccessful()){
                            if(response.body().getResult().get(0).getPseudo().equals(edtPseudo.getText().toString())){
                                if(response.body().getResult().get(0).getPassword().equals(edtPassword.getText().toString())){

                                        Intent intent=new Intent(MainActivity.this,Facturation.class);
                                        intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                                        startActivity(intent);

                                }else {
                                    Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "Pseudo Incorrect", Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Pseudo Incorrect", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                    }
                });

                }
            }
        });
    }
}
