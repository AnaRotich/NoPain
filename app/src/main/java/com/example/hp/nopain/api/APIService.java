package com.example.hp.nopain.api;


import com.example.hp.nopain.models.result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("register")
    Call<result> createUser(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password);


    @FormUrlEncoded
    @POST("login")
    Call<result> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );
}


