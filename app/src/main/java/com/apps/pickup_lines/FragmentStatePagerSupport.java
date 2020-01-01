package com.apps.pickup_lines;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Objects;


public class FragmentStatePagerSupport extends FragmentActivity {

    MyAdapter mAdapter;
    ViewPager mPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        MobileAds.initialize(this, initializationStatus -> {
        });
        AdView mAdView;
        AdView mAdView2;
        mAdView = findViewById(R.id.adView);
        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest2);
        Objects.requireNonNull(getActionBar()).setTitle("Pick Up Lines");
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbar_drawable));
       // Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        OnResponse onResponse = this::afterResponse;
        new Networking(onResponse).execute();

    }

    private void afterResponse(ArrayList arrayList) {

        mAdapter = new MyAdapter(getSupportFragmentManager(), arrayList);
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
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://nirajanhub.github.io/apiTest/privacy_policy.html"));
                startActivity(intent);
                Toast.makeText(this, "https://nirajanhub.github.io/Weather/privacy_policy", Toast.LENGTH_LONG).show();
                return true;
            case R.id.rate_us:
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                }
                catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
