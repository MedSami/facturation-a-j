package com.amina.facturation.API;

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


    /************** Inscription ****************/

    @GET("Inscrire.php")
    Call<ResponseDataModel> Inscrire( @Field("nom") String nom,
                                       @Field("prenom") String prenom,
                                       @Field("email") String email,
                                       @Field("pseudo") String pseudo,
                                       @Field("password") String password);

}
