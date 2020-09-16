package com.ninja.vegitapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VegService {

 @POST("RMIWebServer/Controller")
 Call<VegResponse> addVeg(@Body VegRequest vegRequest);

 @POST("RMIWebServer/UpdateVegetablePrice")
 Call<VegResponse> updateVeg(@Body VegRequest vegRequest);

 @POST("RMIWebServer/DeleteVegetablePrice")
 Call<VegResponse> deleteVeg(@Body VegRequest vegRequest);

 @GET("RMIWebServer/CalculateCost")
 Call<ReceiptResponse> fetch();

 @GET("RMIWebServer/CalVegetableCost")
 Call<CostResponse> cost();



}
