package com.example.evalution_1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

   @GET("api/users")
   Call<ResponseModel> getListOfPages();
}
