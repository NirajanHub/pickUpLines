package com.apps.pickup_lines;

import android.app.FragmentManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;
    private ArrayList arrayList;


    public MyAdapter(@NonNull androidx.fragment.app.FragmentManager fm, int behavior, ArrayList arrayList) {
        super(fm, behavior);
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(arrayList, position);
    }

}
