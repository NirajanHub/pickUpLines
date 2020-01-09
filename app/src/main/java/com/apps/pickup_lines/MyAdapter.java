package com.apps.pickup_lines;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStatePagerAdapter {

    private ArrayList arrayList;

    MyAdapter(androidx.fragment.app.FragmentManager fm, ArrayList arrayList) {
        super(fm);
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
