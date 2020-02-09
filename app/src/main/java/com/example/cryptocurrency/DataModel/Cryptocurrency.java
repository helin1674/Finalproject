package com.example.cryptocurrency.DataModel;

import com.google.gson.annotations.SerializedName;


import java.util.List;

public class Cryptocurrency {

    @SerializedName("cryptocurrenciesList")
    public List<CryptoCurrency> cryptoCurrencyArrayList = null;

    public class CryptoCurrency{

        @SerializedName("ticker")
        public String ticker;

        @SerializedName("name")
        public String name;

        @SerializedName("price")
        public String price;

        @SerializedName("changes")
        public String changes;

        @SerializedName("marketCapitalization")
        public String marketCapitalization;
    }

}
