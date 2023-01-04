package com.example.ptb_10_a.retrofit;

import com.example.ptb_10_a.models.Authorisation;
import com.example.ptb_10_a.models.LogbooksResponse;
import com.example.ptb_10_a.models.LoginResponse;
import com.example.ptb_10_a.models.LogoutResponse;
import com.example.ptb_10_a.models.ProfileResponse;
import com.example.ptb_10_a.models.TmbhLBResponse;
import com.example.ptb_10_a.models.UbahPassword;
import com.example.ptb_10_a.models.UpdateProfilResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface InterfaceMahasiswa {

    @FormUrlEncoded
    @POST("api/login/")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @GET("api/me/")
    Call<ProfileResponse> profile(@Header("token") String token);

    @POST("api/logout/")
    Call<LogoutResponse> logout(@Header("token") String token);

    @GET("api/theses/309/logbooks")
    Call<LogbooksResponse> getLB(@Header("Authorization") String token);

    @POST("/api/password")
    Call<UbahPassword> UbahPassword(@Header("Authorization") String token, @Field("old_password") String old_password, @Field("new_password") String new_password, @Field("confirm_password") String confirm_password);

    @FormUrlEncoded
    @POST("/api/me/update")
    Call<UpdateProfilResponse> updateProfile(@Header("Authorization") String token, @Field("email") String email, @Field("name") String name);

    @FormUrlEncoded
    /*@Headers("Authorization: token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vcHRiLWFwaS5odXNuaWxrYW1pbC5teS5pZC9hcGkvbG9naW4iLCJpYXQiOjE2NzI4NDA3NTEsImV4cCI6MTY3Mjg0NDM1MSwibmJmIjoxNjcyODQwNzUxLCJqdGkiOiJYV0Y4OWhkUm9xYXU3Rlo2Iiwic3ViIjoiMzU2IiwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.91ksESlSTYTE-3-9nhCctPH7m8FrG8slpVgKjTKkoB8")*/
    @POST("api/theses/309/logbooks")
    Call<TmbhLBResponse> postLB(@Header("Authorization") String token,@Field("supervisor_id") Integer supervisor_id, @Field("date") String date, @Field("progress") String progress);
}

