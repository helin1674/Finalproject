package com.example.cryptocurrency.DataModel;

import com.google.gson.annotations.SerializedName;

public class AllMinuteCryptoCurrency {

    @SerializedName("symbol")
    public String symbol;

    @SerializedName("price")
    public String price;

    @SerializedName("changesPercentage")
    public String changesPercentage;

    @SerializedName("change")
    public String change;

    @SerializedName("dayLow")
    public String dayLow;

    @SerializedName("dayHigh")
    public String dayHigh;

    @SerializedName("yearHigh")
    public String yearHigh;

    @SerializedName("yearLow")
    public String yearLow;

    @SerializedName("marketCap")
    public String marketCap;

    @SerializedName("priceAvg50")
    public String priceAvg50;

    @SerializedName("priceAvg200")
    public String priceAvg200;

    @SerializedName("volume")
    public String volume;

    @SerializedName("avgVolume")
    public String avgVolume;

    @SerializedName("exhange")
    public String exhange;

    @SerializedName("open")
    public String open;

    @SerializedName("previousClose")
    public String previousClose;

    @SerializedName("eps")
    public String eps;

    @SerializedName("pe")
    public String pe;

    @SerializedName("earningsAnnouncement")
    public String earningsAnnouncement;

    @SerializedName("sharesOutstanding")
    public String sharesOutstanding;

    @SerializedName("timestamp")
    public String timestamp;
}
