package com.amina.facturation.API;

import com.amina.facturation.Facturation;
import com.amina.facturation.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {


    /******************** Authentification Login*******************/

    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("pseudo") String pseudo);

    /******************** Authentification Login*******************/

    @GET("NumeroFacture.php")
    Call<ResponseDataModel> NumeroFacture();


    /************** Inscription ****************/
    @FormUrlEncoded
    @POST("Inscrire.php")
    Call<ResponseDataModel> Inscrire( @Field("nom") String nom,
                                       @Field("prenom") String prenom,
                                       @Field("email") String email,
                                       @Field("pseudo") String pseudo,
                                       @Field("motdepasse") String password);

    /************** Facturation ****************/
    @FormUrlEncoded
    @POST("Facturation.php")
    Call<ResponseDataModel>Facturation( @Field("montant") String montant,
                                      @Field("netapayer") String netapayer,
                                      @Field("naturedepaiement") String naturedepaiement,
                                      @Field("entreprise_public") String entreprise_public,
                                      @Field("client_abonne") String clien_abonne,
                                      @Field("nom_produit") String nom_produit,
                                      @Field("num_facture") String num_facture,
                                      @Field("matricule") String matricule
                                        );



}
