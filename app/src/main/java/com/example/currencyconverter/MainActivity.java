package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currencyconverter.api.APINinjaService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.math.BigDecimal;
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
    private Button btnSwitch;


    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        start();
    }

    private boolean errorCheck(){
        return  tvInputCurrency != null && tvInputCurrency.getText().equals("")                         ||
                tvInputCurrencySelect!=null && tvInputCurrencySelect.getText().toString().equals("")    ||
                tvOutputCurrencySelect!=null && tvOutputCurrencySelect.getText().toString().equals("");
    }

    private void start() {

        btnConvert.setOnClickListener(e->{
            //tvOutputCurrency.setText(""+Math.ceil(rand.nextDouble()*100));
            if(errorCheck())return;

            Toast toast= Toast.makeText(getApplicationContext(),null, Toast.LENGTH_SHORT);
            apiService.exchangeCurrency(
                    tvOutputCurrencySelect.getText().toString(),
                    tvInputCurrencySelect.getText().toString(),

                    Double.parseDouble(tvInputCurrency.getText().toString()),
                    tvOutputCurrency,tvOutputCurrencyContainer,toast);
        });

        btnSwitch.setOnClickListener(e->{

            //extracted();



            String outputCurrency = tvOutputCurrencySelect.getText().toString();
            String inputCurrency = tvInputCurrencySelect.getText().toString();

            if(outputCurrency.equals(inputCurrency) ||
                    (inputCurrency.equals("") || outputCurrency.equals(""))) return;


            tvOutputCurrencySelect.setText(inputCurrency,false);

            tvInputCurrencySelect.setText(outputCurrency,false);


        });


    }

    private void extracted() {
        int[][] states = new int[][]{
                new int[]{android.R.attr.state_enabled},
                new int[]{-android.R.attr.state_enabled},
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_pressed}
        };

        int[] colors = new int[]{
                Color.BLUE,
                Color.RED,
                Color.CYAN,
                Color.YELLOW
        };

        btnSwitch.setForegroundTintList(new ColorStateList(states,colors));
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
        btnSwitch = findViewById(R.id.btnSwitch);
        //CurrencyList = new String[]{"ZAR","DLR","X"};

        apiService = new APINinjaService();

        String[] arr = CurrenciesDictionary.keySet().toArray(new String[0]);//MapToArrayString();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.currencies_menu,arr);

        tvInputCurrencySelect.setAdapter(adapter);
        tvInputCurrencySelect.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));

        tvOutputCurrencySelect.setAdapter(adapter);
        tvOutputCurrencySelect.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
    }
}