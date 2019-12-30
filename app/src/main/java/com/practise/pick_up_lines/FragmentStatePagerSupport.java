package com.practise.pick_up_lines;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class FragmentStatePagerSupport extends FragmentActivity {
    static final int NUM_ITEMS = 10;

    MyAdapter mAdapter;

    ViewPager mPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        mAdapter=new MyAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,NUM_ITEMS);
        mPager=findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

    }
}
