package com.example.currencyconverter;


import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;


public class Util {
    public static final String BASE_URL ="https://api.api-ninjas.com/v1/";
    public static final String CONVERT_CURRENCY="convertcurrency";
    public static final String HAVE="have";
    public static final String WANT="want";
    public static final String AMOUNT="amount";

    public static final String INVALID_CURRENCY = "Invalid currencies.";

    public static final SortedMap<String,String> CurrenciesDictionary ;

    static{

        SortedMap<String,String> temp = new TreeMap<>();
        temp.put("Australia Dollar","AUD");
        temp.put("Great Britain Pound","GBP");
        temp.put("Euro","EUR");
        temp.put("Japan Yen","JPY");
        temp.put("Switzerland Franc","CHF");
        temp.put("USA Dollar","USD");
        temp.put("Afghanistan Afghani","AFN");
        temp.put("Albania Lek","ALL");
        temp.put("Algeria Dinar","DZD");
        temp.put("Angola Kwanza","AOA");
        temp.put("Argentina Peso","ARS");
        temp.put("Armenia Dram","AMD");
        temp.put("Aruba Florin","AWG");

        temp.put("Austria Schilling","ATS");
        temp.put("Belgium Franc","BEF");
        temp.put("Azerbaijan New Manat","AZN");
        temp.put("Bahamas Dollar","BSD");
        temp.put("Bahrain Dinar","BHD");
        temp.put("Bangladesh Taka","BDT");
        temp.put("Barbados Dollar","BBD");
        temp.put("Belarus Ruble","BYR");
        temp.put("Belize Dollar","BZD");
        temp.put("Bermuda Dollar","BMD");
        temp.put("Bhutan Ngultrum","BTN");
        temp.put("Bolivia Boliviano","BOB");
        temp.put("Bosnia Mark","BAM");
        temp.put("Botswana Pula","BWP");
        temp.put("Brazil Real","BRL");

        temp.put("Brunei Dollar","BND");
        temp.put("Bulgaria Lev","BGN");
        temp.put("Burundi Franc","BIF");
        temp.put("CFA Franc BCEAO","XOF");
        temp.put("CFA Franc BEAC","XAF");
        temp.put("CFP Franc","XPF");
        temp.put("Cambodia Riel","KHR");
        temp.put("Canada Dollar","CAD");
        temp.put("Cape Verde Escudo","CVE");
        temp.put("Cayman Islands Dollar","KYD");
        temp.put("Chili Peso","CLP");
        temp.put("China Yuan/Renminbi","CNY");
        temp.put("Colombia Peso","COP");
        temp.put("Comoros Franc","KMF");
        temp.put("Congo Franc","CDF");
        temp.put("Costa Rica Colon","CRC");
        temp.put("Croatia Kuna","HRK");
        temp.put("Cuba Convertible Peso","CUC");
        temp.put("Cuba Peso","CUP");
        temp.put("Cyprus Pound","CYP");
        temp.put("Czech Koruna","CZK");
        temp.put("Denmark Krone","DKK");
        temp.put("Djibouti Franc","DJF");
        temp.put("Dominican Republich Peso","DOP");
        temp.put("East Caribbean Dollar","XCD");
        temp.put("Egypt Pound","EGP");
        temp.put("El Salvador Colon","SVC");
        temp.put("Estonia Kroon","EEK");
        temp.put("Ethiopia Birr","ETB");

        temp.put("Falkland Islands Pound","FKP");
        temp.put("Finland Markka","FIM");
        temp.put("Fiji Dollar","FJD");
        temp.put("Gambia Dalasi","GMD");
        temp.put("Georgia Lari","GEL");
        temp.put("Germany Mark","DMK");
        temp.put("Ghana New Cedi","GHS");
        temp.put("Gibraltar Pound","GIP");
        temp.put("Greece Drachma","GRD");
        temp.put("Guatemala Quetzal","GTQ");
        temp.put("Guinea Franc","GNF");
        temp.put("Guyana Dollar","GYD");
        temp.put("Haiti Gourde","HTG");
        temp.put("Honduras Lempira","HNL");
        temp.put("Hong Kong Dollar","HKD");
        temp.put("Hungary Forint","HUF");
        temp.put("Iceland Krona","ISK");
        temp.put("India Rupee","INR");
        temp.put("Indonesia Rupiah","IDR");
        temp.put("Iran Rial","IRR");
        temp.put("Iraq Dinar","IQD");
        temp.put("Ireland Pound","IED");
        temp.put("Israel New Shekel","ILS");
        temp.put("Italy Lira","ITL");
        temp.put("Jamaica Dollar","JMD");


        temp.put("Jordan Dinar","JOD");
        temp.put("Kazakhstan Tenge","KZT");
        temp.put("Kenya Shilling","KES");
        temp.put("Kuwait Dinar","KWD");
        temp.put("Kyrgyzstan Som","KGS");
        temp.put("Laos Kip","LAK");
        temp.put("Latvia Lats","LVL");
        temp.put("Lebanon Pound","LBP");
        temp.put("Lesotho Loti","LSL");
        temp.put("Liberia Dollar","LRD");
        temp.put("Libya Dinar","LYD");
        temp.put("Lithuania Litas","LTL");
        temp.put("Luxembourg Franc","LUF");
        temp.put("Macau Pataca","MOP");
        temp.put("Macedonia Denar","MKD");
        temp.put("Malagasy Ariary","MGA");
        temp.put("Malawi Kwacha","MWK");
        temp.put("Malaysia Ringgit","MYR");
        temp.put("Maldives Rufiyaa","MVR");
        temp.put("Malta Lira","MTL");
        temp.put("Mauritania Ouguiya","MRO");
        temp.put("Mauritius Rupee","MUR");
        temp.put("Mexico Peso","MXN");
        temp.put("Moldova Leu","MDL");
        temp.put("Mongolia Tugrik","MNT");
        temp.put("Morocco Dirham","MAD");
        temp.put("Mozambique New Metical","MZN");
        temp.put("Myanmar Kyat","MMK");
        temp.put("NL Antilles Guilder","ANG");
        temp.put("Namibia Dollar","NAD");
        temp.put("Nepal Rupee","NPR");
        temp.put("Netherlands Guilder","NLG");
        temp.put("New Zealand Dollar","NZD");
        temp.put("Nicaragua Cordoba Oro","NIO");
        temp.put("Nigeria Naira","NGN");
        temp.put("North Korea Won","KPW");
        temp.put("Norway Kroner","NOK");
        temp.put("Oman Rial","OMR");
        temp.put("Pakistan Rupee","PKR");
        temp.put("Panama Balboa","PAB");
        temp.put("Papua New Guinea Kina","PGK");
        temp.put("Paraguay Guarani","PYG");
        temp.put("Peru Nuevo Sol","PEN");
        temp.put("Philippines Peso","PHP");
        temp.put("Poland Zloty","PLN");
        temp.put("Portugal Escudo","PTE");
        temp.put("Qatar Rial","QAR");
        temp.put("Romania New Lei","RON");
        temp.put("Russia Rouble","RUB");
        temp.put("Rwanda Franc","RWF");
        temp.put("Samoa Tala","WST");
        temp.put("Sao Tome/Principe Dobra","STD");
        temp.put("Saudi Arabia Riyal","SAR");
        temp.put("Serbia Dinar","RSD");
        temp.put("Seychelles Rupee","SCR");
        temp.put("Sierra Leone Leone","SLL");
        temp.put("Singapore Dollar","SGD");
        temp.put("Slovakia Koruna","SKK");
        temp.put("Slovenia Tolar","SIT");
        temp.put("Solomon Islands Dollar","SBD");
        temp.put("Somali Shilling","SOS");
        temp.put("South Africa Rand","ZAR");
        temp.put("South Korea Won","KRW");
        temp.put("Spain Peseta","ESP");
        temp.put("Sri Lanka Rupee","LKR");
        temp.put("St Helena Pound","SHP");
        temp.put("Sudan Pound","SDG");
        temp.put("Suriname Dollar","SRD");
        temp.put("Swaziland Lilangeni","SZL");
        temp.put("Sweden Krona","SEK");

        temp.put("Syria Pound","SYP");
        temp.put("Taiwan Dollar","TWD");
        temp.put("Tanzania Shilling","TZS");
        temp.put("Thailand Baht","THB");
        temp.put("Tonga Pa'anga","TOP");
        temp.put("Trinidad/Tobago Dollar","TTD");
        temp.put("Tunisia Dinar","TND");
        temp.put("Turkish New Lira","TRY");
        temp.put("Turkmenistan Manat","TMM");

        temp.put("Uganda Shilling","UGX");
        temp.put("Ukraine Hryvnia","UAH");
        temp.put("Uruguay Peso","UYU");
        temp.put("United Arab Emirates Dirham","AED");
        temp.put("Vanuatu Vatu","VUV");
        temp.put("Venezuela Bolivar","VEB");
        temp.put("Vietnam Dong","VND");
        temp.put("Yemen Rial","YER");
        temp.put("Zambia Kwacha","ZMK");
        temp.put("Zimbabwe Dollar","ZWD");


        CurrenciesDictionary = Collections.unmodifiableSortedMap(temp);
    }



    public static String[] MapToArrayString(){
        String[] arr = new String[CurrenciesDictionary.size()];


        int i = 0;
        for (Map.Entry<String, String> entry : CurrenciesDictionary.entrySet()) {
            arr[i++] = entry.getKey() + " - " + entry.getValue();
        }

        return  arr;
    }

}
