package com.example.cryptocurrency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.DataModel.CurrencyExchangeRate;
import com.example.cryptocurrency.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdapterCurrencyExchangeRate extends RecyclerView.Adapter {

    Context context;
    List<CurrencyExchangeRate.Forex> forexList = new LinkedList<CurrencyExchangeRate.Forex>();

    public AdapterCurrencyExchangeRate(Context context, List<CurrencyExchangeRate.Forex> forexList) {
        this.context = context;
        this.forexList = forexList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency_exchange_rate, parent, false);
        AdapterCurrencyExchangeRate.MyViewHolder viewHolder = new AdapterCurrencyExchangeRate.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdapterCurrencyExchangeRate.MyViewHolder viewHolder = (MyViewHolder) holder;

        if (forexList.get(position) != null) {
            if (forexList.get(position).ticker != null && !(forexList.get(position).ticker.equals(null)))
                viewHolder.tvTicker.setText(forexList.get(position).ticker);
            if (forexList.get(position).date != null && !(forexList.get(position).date.equals(null)))
                viewHolder.tvDate.setText(forexList.get(position).date);
            if (forexList.get(position).bid != null && !(forexList.get(position).bid.equals(null)))
                viewHolder.tvBid.setText(forexList.get(position).bid);
            if (forexList.get(position).ask != null && !(forexList.get(position).ask.equals(null)))
                viewHolder.tvAsk.setText(forexList.get(position).ask);
            if (forexList.get(position).open != null && !(forexList.get(position).open.equals(null)))
                viewHolder.tvOpen.setText(forexList.get(position).open);
            if (forexList.get(position).low != null && !(forexList.get(position).low.equals(null)))
                viewHolder.tvLow.setText(forexList.get(position).low);
            if (forexList.get(position).high != null && !(forexList.get(position).high.equals(null)))
                viewHolder.tvHigh.setText(forexList.get(position).high);
            if (forexList.get(position).changes != null  && !(forexList.get(position).changes.equals(null)))
                viewHolder.tvChanges.setText(forexList.get(position).changes);
        }
    }

    @Override
    public int getItemCount() {
        return forexList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTicker, tvDate, tvBid, tvAsk, tvOpen, tvLow, tvHigh, tvChanges;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvTicker = (TextView) itemView.findViewById(R.id.tvTiker);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.tvBid = (TextView) itemView.findViewById(R.id.tvBid);
            this.tvAsk = (TextView) itemView.findViewById(R.id.tvAsk);
            this.tvOpen = (TextView) itemView.findViewById(R.id.tvOpen);
            this.tvLow = (TextView) itemView.findViewById(R.id.tvLow);
            this.tvHigh = (TextView) itemView.findViewById(R.id.tvHight);
            this.tvChanges = (TextView) itemView.findViewById(R.id.tvChanges);
        }
    }
}
