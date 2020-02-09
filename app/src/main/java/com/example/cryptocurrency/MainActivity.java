package com.example.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.cryptocurrency.Fragment.FragmentHome;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout frameLayout;
    static Fragment myFragment ;

    @Override
    public void onBackPressed()
    {

        myFragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);

        if (getSupportFragmentManager() != null) {
            if (this.getSupportFragmentManager().getBackStackEntryCount() > 0) {
                Fragment fragmentBeforeBackPress = getCurrentFragment();
                if (fragmentBeforeBackPress != null)
                    if (fragmentBeforeBackPress.getTag() == "SecretCodeList")
                        this.getSupportFragmentManager().popBackStackImmediate();
                this.getSupportFragmentManager().popBackStackImmediate();
            }
        }
    }

    private Fragment getCurrentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        Fragment currentFragment = fragmentManager.findFragmentByTag(fragmentTag);
        return currentFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setHomeFragment();

    }

    public void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Forex (FX)");
        frameLayout = (FrameLayout) findViewById(R.id.frame_container);
    }

    public void setHomeFragment(){
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, new FragmentHome(MainActivity.this),"FragmentHome").commit();
    }
}
