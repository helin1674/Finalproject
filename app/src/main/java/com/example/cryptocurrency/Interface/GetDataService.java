package com.example.cryptocurrency.Interface;

import com.example.cryptocurrency.DataModel.AllMinuteCryptoCurrency;
import com.example.cryptocurrency.DataModel.AllMinuteForexPrice;
import com.example.cryptocurrency.DataModel.Cryptocurrency;
import com.example.cryptocurrency.DataModel.CurrencyExchangeRate;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/api/v3/forex")
    Call<CurrencyExchangeRate> getAllCurrencyExchangeRate();

    @GET("/api/v3/quotes/forex")
    Call<List<AllMinuteForexPrice>> getAllMinuteForexPrice();

    @GET("/api/v3/cryptocurrencies")
    Call<Cryptocurrency> getAllCryptoCurrency();

    @GET("/api/v3/quotes/crypto")
    Call<List<AllMinuteCryptoCurrency>> getAllMinuteCryptoCurrency();
}