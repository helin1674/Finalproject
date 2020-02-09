package com.example.cryptocurrency.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cryptocurrency.DataModel.AllMinuteCryptoCurrency;
import com.example.cryptocurrency.DataModel.AllMinuteForexPrice;
import com.example.cryptocurrency.R;

public class FragmentDetailInfo extends Fragment {

    Context context;
    boolean isForex;
    AllMinuteCryptoCurrency cryptoCurrency;
    AllMinuteForexPrice forexPrice;
    TextView tvPrice, tvChangePer, tvDayLow, tvDayHight, tvYearHigh, tvYearLow,tvMarketCap, tvPrice50, tvPrice200,
            tvVol, tvAvgVol, tvExchange, tvOpen, tvPrevClose, tvEps, tvPE, tvEarningAnnouncement, tvShareOut, tvTimestamp;

    public FragmentDetailInfo(Context context, AllMinuteCryptoCurrency allMinuteCryptoCurrency,boolean isForex) {
        this.context = context;
        this.isForex = isForex;
        cryptoCurrency = allMinuteCryptoCurrency;
    }

    public FragmentDetailInfo(Context context, AllMinuteForexPrice allMinuteForexPrice) {
        this.context = context;
        this.isForex = false;
        forexPrice = allMinuteForexPrice;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_information, container, false);
        findViews(view);
        setData();
        return view;
    }

    public void findViews(View view) {
        tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        tvChangePer = (TextView) view.findViewById(R.id.tvChangePer);
        tvDayLow = (TextView) view.findViewById(R.id.tvDayLow);
        tvDayHight = (TextView) view.findViewById(R.id.tvDayHigh);
        tvYearHigh = (TextView) view.findViewById(R.id.tvHigh);
        tvYearLow = (TextView) view.findViewById(R.id.tvYearLow);
        tvMarketCap = (TextView) view.findViewById(R.id.tvMarketCap);
        tvPrice50 = (TextView) view.findViewById(R.id.tvPice50);
        tvPrice200 = (TextView) view.findViewById(R.id.tvPrice200);
        tvVol = (TextView) view.findViewById(R.id.tvVol);
        tvAvgVol = (TextView) view.findViewById(R.id.tvAvgVol);
        tvExchange = (TextView) view.findViewById(R.id.tvExchange);
        tvOpen = (TextView) view.findViewById(R.id.tvOpen);
        tvPrevClose = (TextView) view.findViewById(R.id.tvPrevClose);
        tvEps = (TextView) view.findViewById(R.id.tvEPS);
        tvPE = (TextView) view.findViewById(R.id.tvPe);
        tvEarningAnnouncement = (TextView) view.findViewById(R.id.tvEarningAnnouncement);
        tvShareOut = (TextView) view.findViewById(R.id.tvShareOut);
        tvTimestamp = (TextView) view.findViewById(R.id.tvTimestamp);
    }

    public void setData(){
        if (isForex)
        {
            tvPrice.setText(cryptoCurrency.price);
            tvChangePer.setText(cryptoCurrency.changesPercentage);
            tvDayHight.setText(cryptoCurrency.dayHigh);
            tvDayLow.setText(cryptoCurrency.dayLow);
            tvYearLow.setText(cryptoCurrency.yearLow);
            tvYearHigh.setText(cryptoCurrency.yearHigh);
            tvMarketCap.setText(cryptoCurrency.marketCap);
            tvPrice50.setText(cryptoCurrency.priceAvg50);
            tvPrice200.setText(cryptoCurrency.priceAvg200);
            tvVol.setText(cryptoCurrency.volume);
            tvAvgVol.setText(cryptoCurrency.avgVolume);
            tvExchange.setText(cryptoCurrency.exhange);
            tvOpen.setText(cryptoCurrency.open);
            tvPrevClose.setText(cryptoCurrency.previousClose);
            tvEps.setText(cryptoCurrency.eps);
            tvPE.setText(cryptoCurrency.pe);
            tvEarningAnnouncement.setText(cryptoCurrency.earningsAnnouncement);
            tvShareOut.setText(cryptoCurrency.sharesOutstanding);
            tvTimestamp.setText(cryptoCurrency.timestamp);
        }else {
            tvPrice.setText(forexPrice.price);
            tvChangePer.setText(forexPrice.changesPercentage);
            tvDayHight.setText(forexPrice.dayHigh);
            tvDayLow.setText(forexPrice.dayLow);
            tvYearLow.setText(forexPrice.yearLow);
            tvYearHigh.setText(forexPrice.yearHigh);
            tvMarketCap.setText(forexPrice.marketCap);
            tvPrice50.setText(forexPrice.priceAvg50);
            tvPrice200.setText(forexPrice.priceAvg200);
            tvVol.setText(forexPrice.volume);
            tvAvgVol.setText(forexPrice.avgVolume);
            tvExchange.setText(forexPrice.exhange);
            tvOpen.setText(forexPrice.open);
            tvPrevClose.setText(forexPrice.previousClose);
            tvEps.setText(forexPrice.eps);
            tvPE.setText(forexPrice.pe);
            tvEarningAnnouncement.setText(forexPrice.earningsAnnouncement);
            tvShareOut.setText(forexPrice.sharesOutstanding);
            tvTimestamp.setText(forexPrice.timestamp);
        }
    }
}
