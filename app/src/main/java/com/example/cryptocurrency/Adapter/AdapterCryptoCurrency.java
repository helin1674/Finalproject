package com.example.cryptocurrency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.DataModel.AllMinuteForexPrice;
import com.example.cryptocurrency.DataModel.Cryptocurrency;
import com.example.cryptocurrency.DataModel.CurrencyExchangeRate;
import com.example.cryptocurrency.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdapterCryptoCurrency extends  RecyclerView.Adapter{

    Context context;
    List<Cryptocurrency.CryptoCurrency> cryptoCurrencyArrayList;

    public AdapterCryptoCurrency(Context context, List<Cryptocurrency.CryptoCurrency> cryptoCurrencyArrayList){
        this.context = context;
        this.cryptoCurrencyArrayList = cryptoCurrencyArrayList;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cryptocurrency, parent, false);
        AdapterCryptoCurrency.MyViewHolder viewHolder = new AdapterCryptoCurrency.MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdapterCryptoCurrency.MyViewHolder viewHolder = (AdapterCryptoCurrency.MyViewHolder) holder;
        if (cryptoCurrencyArrayList.get(position) != null) {
            if (cryptoCurrencyArrayList.get(position).ticker != null && !(cryptoCurrencyArrayList.get(position).ticker.equals(null)))
                viewHolder.tvTicker.setText(cryptoCurrencyArrayList.get(position).ticker);
            if (cryptoCurrencyArrayList.get(position).price != null && !(cryptoCurrencyArrayList.get(position).price.equals(null)))
                viewHolder.tvPrice.setText(cryptoCurrencyArrayList.get(position).price);
            if (cryptoCurrencyArrayList.get(position).changes != null && !(cryptoCurrencyArrayList.get(position).changes.equals(null)))
                viewHolder.tvChanges.setText(cryptoCurrencyArrayList.get(position).changes);
            if (cryptoCurrencyArrayList.get(position).marketCapitalization != null && !(cryptoCurrencyArrayList.get(position).marketCapitalization.equals(null)))
                viewHolder.tvMarketChap.setText(cryptoCurrencyArrayList.get(position).marketCapitalization);
        }
    }

    @Override
    public int getItemCount() {
        return cryptoCurrencyArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTicker, tvPrice, tvChanges, tvMarketChap;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvTicker = (TextView) itemView.findViewById(R.id.tvTiker);
            this.tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            this.tvChanges = (TextView) itemView.findViewById(R.id.tvChanges);
            tvMarketChap = (TextView) itemView.findViewById(R.id.tvMarketCap);
        }
    }
}
