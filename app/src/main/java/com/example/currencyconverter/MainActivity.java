package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconverter.api.APINinjaService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

import static com.example.currencyconverter.Util.CurrenciesDictionary;
import static com.example.currencyconverter.Util.MapToArrayString;

public class MainActivity extends AppCompatActivity {

    private APINinjaService apiService;
    private TextView tvInputCurrency;
    private TextInputLayout tvInputCurrencyContainer;

    private AutoCompleteTextView tvInputCurrencySelect;
    private TextInputLayout tvInputCurrencyContainerSelect;


    private AutoCompleteTextView tvOutputCurrencySelect;
    private TextInputLayout tvOutputCurrencyContainerSelect;

    private TextView tvOutputCurrency;
    private TextInputLayout tvOutputCurrencyContainer;

    private Button btnConvert;

    private String[] CurrencyList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        start();
    }

    private void errorCheck(){}

    private void start() {

        btnConvert.setOnClickListener(e->{
            //tvOutputCurrency.setText(""+Math.ceil(rand.nextDouble()*100));
            errorCheck();

            Toast toast= Toast.makeText(getApplicationContext(),null, Toast.LENGTH_SHORT);
            apiService.exchangeCurrency(
                    tvOutputCurrencySelect.getText().toString(),
                    tvInputCurrencySelect.getText().toString(),

                    Double.parseDouble(tvInputCurrency.getText().toString()),
                    tvOutputCurrency,tvOutputCurrencyContainer,toast);
        });


    }


    private void init(){
        tvInputCurrency = findViewById(R.id.txtInputCurrency);
        tvInputCurrencyContainer = findViewById(R.id.txtInputCurrencyContainer);

        tvInputCurrencySelect = findViewById(R.id.txtInputCurrencySelect);
        tvInputCurrencyContainerSelect = findViewById(R.id.txtInputCurrencySelectContainer);

        tvOutputCurrencySelect= findViewById(R.id.txtOutputCurrencySelect);
        tvOutputCurrencyContainerSelect = findViewById(R.id.txtOutputCurrencySelectContainer);

        tvOutputCurrency = findViewById(R.id.txtOutputCurrency);
        tvOutputCurrencyContainer = findViewById(R.id.txtOutputCurrencyContainer);

        btnConvert = findViewById(R.id.btnConvert);
        //CurrencyList = new String[]{"ZAR","DLR","X"};

        apiService = new APINinjaService();

        String[] arr = CurrenciesDictionary.keySet().toArray(new String[0]);//MapToArrayString();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.currencies_menu,arr);

        tvInputCurrencySelect.setAdapter(adapter);
        tvOutputCurrencySelect.setAdapter(adapter);
    }
}