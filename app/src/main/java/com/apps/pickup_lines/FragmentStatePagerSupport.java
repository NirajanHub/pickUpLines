package com.apps.pickup_lines;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;


public class FragmentStatePagerSupport extends FragmentActivity {

    MyAdapter mAdapter;
    ViewPager mPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        MobileAds.initialize(this, initializationStatus -> {});
        OnResponse onResponse = this::afterResponse;
        new Networking(onResponse).execute();
    }

    private void afterResponse(ArrayList arrayList) {
        mAdapter = new MyAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, arrayList);
        mPager = findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.privacy_policy:
            case R.id.rate_us:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
