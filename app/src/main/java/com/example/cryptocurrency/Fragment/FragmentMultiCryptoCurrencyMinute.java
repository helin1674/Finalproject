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
import com.example.cryptocurrency.Adapter.AdapterCurrencyExchangeRate;
import com.example.cryptocurrency.DataModel.AllMinuteCryptoCurrency;
import com.example.cryptocurrency.DataModel.CurrencyExchangeRate;
import com.example.cryptocurrency.HTTPUtils.RetrofitClientInstance;
import com.example.cryptocurrency.Interface.GetDataService;
import com.example.cryptocurrency.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMultiCryptoCurrencyMinute extends Fragment {

    Context context;
    RecyclerView recyclerView;
    AdapterCryptoCurrencyMinute adapterCryptoCurrencyMinute;

    public FragmentMultiCryptoCurrencyMinute(Context context)
    {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_minute_cryptocurrency, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        callApi();
        return view;
    }

    ProgressDialog progressDoalog;

    public void callApi(){
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<AllMinuteCryptoCurrency>> call = service.getAllMinuteCryptoCurrency();

        call.enqueue(new Callback<List<AllMinuteCryptoCurrency>>() {
            @Override
            public void onResponse(Call<List<AllMinuteCryptoCurrency>> call, final Response<List<AllMinuteCryptoCurrency>> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()) {
                    adapterCryptoCurrencyMinute = new AdapterCryptoCurrencyMinute(context, response.body(), new AdapterCryptoCurrencyMinute.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            //Detail Fragment

                            final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                            transaction.add(R.id.frame_container, new FragmentDetailInfo(context,response.body().get(position),true), "FragmentDetailInfo");
                            transaction.addToBackStack("FragmentDetailInfo");
                            transaction.commit();
                        }
                    });
                    recyclerView.setAdapter(adapterCryptoCurrencyMinute);
                }else
                {
                    Toast.makeText(context,"Something went wrong please try again later",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<AllMinuteCryptoCurrency>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
