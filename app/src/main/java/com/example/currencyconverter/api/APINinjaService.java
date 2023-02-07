package com.example.currencyconverter.api;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconverter.models.APINinjaModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.currencyconverter.Util.BASE_URL;
import static com.example.currencyconverter.Util.CurrenciesDictionary;
import static com.example.currencyconverter.Util.INVALID_CURRENCY;

public class APINinjaService {
    private IEndpointsAPINinja api;
    private Retrofit retrofit;

    public APINinjaService(){
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(IEndpointsAPINinja.class);
    }


    public void exchangeCurrency(String req, String res, double amount, TextView tvOutput, TextInputLayout tvOutputContainer, Toast errorToast){

        String a = CurrenciesDictionary.get(req);
        String b = CurrenciesDictionary.get(res);
        Call<APINinjaModel> call = api.get(a,b,1);

        call.enqueue(new Callback<APINinjaModel>() {
            @Override
            public void onResponse(Call<APINinjaModel> call, Response<APINinjaModel> response) {

                if(response.isSuccessful()){
                    APINinjaModel res = response.body();
                    if (res != null) {


                        if(Objects.equals(res.error, INVALID_CURRENCY)){
                            errorToast.setText("Provided Currency not supported yet.");
                            errorToast.show();
                        }

                        tvOutput.setText(String.valueOf(res.new_amount*amount));


                    }else{
                        errorToast.setText("Unknown error occurred.");
                        errorToast.show();
                        //tvOutputContainer.seth
                    }


                }else{
                    errorToast.setText("Internal error occurred.");
                    errorToast.show();
                }
            }

            @Override
            public void onFailure(Call<APINinjaModel> call, Throwable t) {

            }
        });
    }


}
