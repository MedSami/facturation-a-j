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
    /************** Select tous les classes ****************/
    @GET("SelectAllClasses.php")
    Call<ResponseDataModel> getClasse(@Query("id_classe") int id_classe);

    /************** Select tous les matieres ****************/
    @GET("SelectMatiere.php")
    Call<ResponseDataModel> getMatiere(@Query("id_classe") int id_classe);

    /************** Select tous les eleves ****************/
    @GET("SelectEleve.php")
    Call<ResponseDataModel> getEleves(@Query("id_classe") int id_classe);


    /*************** Inscrire *******************/
    @FormUrlEncoded
    @POST("AbsentRetardExclu.php")
    Call<ResponseDataModel> AbsentRetardExclu(
            @Field("absent") String absent,
            @Field("retard") String retard,
            @Field("exclu") String exclu,
            @Field("date") String date,
            @Field("rapport") String rapport,
            @Field("id_eleve") int idEleve,
            @Field("id_matiere") int idMatiere,
            @Field("id_classe") int idClasse,
            @Field("id_enseignant") String idEnsegnant

    );

}
