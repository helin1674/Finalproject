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
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.Adapter.AdapterCryptoCurrency;
import com.example.cryptocurrency.Adapter.AdapterCryptoCurrencyMinute;
import com.example.cryptocurrency.Adapter.AdapterCurrencyMinute;
import com.example.cryptocurrency.DataModel.AllMinuteForexPrice;
import com.example.cryptocurrency.DataModel.CurrencyExchangeRate;
import com.example.cryptocurrency.HTTPUtils.RetrofitClientInstance;
import com.example.cryptocurrency.Interface.GetDataService;
import com.example.cryptocurrency.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMultiCurrencyMinute extends Fragment {

    Context context;
    RecyclerView recyclerView;
    AdapterCurrencyMinute adapterCurrencyMinute;

    public FragmentMultiCurrencyMinute(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_minute_forex_price, container, false);
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
        Call<List<AllMinuteForexPrice>> call = service.getAllMinuteForexPrice();

        call.enqueue(new Callback<List<AllMinuteForexPrice>>() {
            @Override
            public void onResponse(Call<List<AllMinuteForexPrice>> call, final Response<List<AllMinuteForexPrice>> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    adapterCurrencyMinute = new AdapterCurrencyMinute(context, response.body(), new AdapterCurrencyMinute.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                            transaction.add(R.id.frame_container, new FragmentDetailInfo(context,response.body().get(position)), "FragmentDetailInfo");
                            transaction.addToBackStack("FragmentDetailInfo");
                            transaction.commit();
                        }
                    });
                    recyclerView.setAdapter(adapterCurrencyMinute);
                } else {
                    Toast.makeText(context, "Something went wrong please try again later", Toast.LENGTH_SHORT).show();
                }

                Log.e("FragmentMultiCurrency", response.body().get(10).symbol + "");
            }

            @Override
            public void onFailure(Call<List<AllMinuteForexPrice>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
