package com.example.cryptocurrency.DataModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CurrencyExchangeRate {

    @SerializedName("forexList")
    public ArrayList<Forex> forexListArrayList = null;

    public class Forex{

        @SerializedName("ticker")
        public String ticker;

        @SerializedName("bid")
        public String bid;

        @SerializedName("ask")
        public String ask;

        @SerializedName("open")
        public String open;

        @SerializedName("low")
        public String low;

        @SerializedName("high")
        public String high;

        @SerializedName("changes")
        public String changes;

        @SerializedName("date")
        public String date;



    }
}
