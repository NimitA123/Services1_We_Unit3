package com.example.evalution_1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

   @GET("/Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db")
   Call<ResponseModel> getListOfPages();
}
