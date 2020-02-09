package com.example.cryptocurrency.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.Adapter.AdapterCryptoCurrency;
import com.example.cryptocurrency.DataModel.Cryptocurrency;
import com.example.cryptocurrency.DataModel.CurrencyExchangeRate;
import com.example.cryptocurrency.HTTPUtils.RetrofitClientInstance;
import com.example.cryptocurrency.Interface.GetDataService;
import com.example.cryptocurrency.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCryptocurrency extends Fragment {

    Context context;
    RecyclerView recyclerView;
    AdapterCryptoCurrency adapterCryptoCurrency;

    public FragmentCryptocurrency(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cryptocurrencies, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        callApi();
        return view;
    }

    ProgressDialog progressDoalog;

    public void callApi() {
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Cryptocurrency> call = service.getAllCryptoCurrency();

        call.enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    adapterCryptoCurrency = new AdapterCryptoCurrency(context, response.body().cryptoCurrencyArrayList);
                    recyclerView.setAdapter(adapterCryptoCurrency);
                } else {
                    Toast.makeText(context, "Something went wrong please try again later", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
