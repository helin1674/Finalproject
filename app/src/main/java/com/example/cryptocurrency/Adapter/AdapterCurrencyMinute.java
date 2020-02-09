package com.example.cryptocurrency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.DataModel.AllMinuteForexPrice;
import com.example.cryptocurrency.R;

import java.util.List;

public class AdapterCurrencyMinute extends RecyclerView.Adapter {

    Context context;
    List<AllMinuteForexPrice> listAllMinuteCrypto;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public AdapterCurrencyMinute(Context context, List<AllMinuteForexPrice> body, @NonNull AdapterCurrencyMinute.OnItemClickListener onItemClickListener) {
        this.context = context;
        listAllMinuteCrypto = body;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency_all_minute, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        if (listAllMinuteCrypto != null) {
            if (listAllMinuteCrypto.get(position).symbol != null && !(listAllMinuteCrypto.get(position).symbol.equals(null)))
                viewHolder.tvSymbol.setText(listAllMinuteCrypto.get(position).symbol);
            if (listAllMinuteCrypto.get(position).price != null && !(listAllMinuteCrypto.get(position).price.equals(null)))
                viewHolder.tvPrice.setText(listAllMinuteCrypto.get(position).price);
        }

        viewHolder.llMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAllMinuteCrypto.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvSymbol, tvPrice;
        LinearLayout llMoreDetails;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvSymbol = (TextView) itemView.findViewById(R.id.tvSymbol);
            this.tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            this.llMoreDetails = (LinearLayout) itemView.findViewById(R.id.llMoreDetails);
        }
    }
}
