package com.example.cryptocurrency.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cryptocurrency.R;

public class FragmentHome extends Fragment implements View.OnClickListener {


    Context context;
    LinearLayout singleCurrency, singleCurrencyMinute, multiCurrency, multiCurrencyMinute;

    public FragmentHome(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        findViews(view);
        return view;
    }

    public void findViews(View view) {
        singleCurrency = (LinearLayout) view.findViewById(R.id.llSingleCurrency);
        singleCurrencyMinute = (LinearLayout) view.findViewById(R.id.llSingleCurrencyMinute);

        multiCurrency = (LinearLayout) view.findViewById(R.id.llMultiCurrency);
        multiCurrencyMinute = (LinearLayout) view.findViewById(R.id.llMultiCurrencyMinute);

        singleCurrencyMinute.setOnClickListener(this);
        singleCurrency.setOnClickListener(this);
        multiCurrency.setOnClickListener(this);
        multiCurrencyMinute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == singleCurrency) {
            FragmentTransition(new FragmentCryptocurrency(context), "FragmentCryptocurrency");
        } else if (v == singleCurrencyMinute) {
            FragmentTransition(new FragmentMultiCryptoCurrencyMinute(context), "FragmentMultiCryptoCurrencyMinute");
        } else if (v == multiCurrency) {
            FragmentTransition(new FragmentMultiCurrency(context), "FragmentMultiCurrency");
        } else if (v == multiCurrencyMinute) {
            FragmentTransition(new FragmentMultiCurrencyMinute(context), "FragmentMultiCurrencyMinute");
        }
    }


    public void FragmentTransition(Fragment fragment, String tag)
    {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transaction.add(R.id.frame_container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
}
