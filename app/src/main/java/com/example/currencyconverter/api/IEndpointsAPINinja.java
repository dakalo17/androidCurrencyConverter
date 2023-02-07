package com.example.currencyconverter.api;

import com.example.currencyconverter.models.APINinjaModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.example.currencyconverter.Util.AMOUNT;
import static com.example.currencyconverter.Util.CONVERT_CURRENCY;
import static com.example.currencyconverter.Util.HAVE;
import static com.example.currencyconverter.Util.WANT;

public interface IEndpointsAPINinja {

    @Headers("X-Api-Key: nzAgj3q+4MqYbmYnm+sXqg==3brkK7wEl5sqUWH6")
    @GET(CONVERT_CURRENCY)
    Call<APINinjaModel> get(@Query(WANT)String want,@Query(HAVE)String have,@Query(AMOUNT)double amount);
}
