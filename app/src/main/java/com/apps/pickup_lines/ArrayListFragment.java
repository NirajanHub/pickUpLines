package com.apps.pickup_lines;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;

public class ArrayListFragment extends Fragment implements View.OnClickListener {
    private int mNum;
    private static ArrayList<Model> arrayListHere;

    static ArrayListFragment newInstance(ArrayList arrayList, int mNum) {
        ArrayListFragment f = new ArrayListFragment();
        arrayListHere = arrayList;
        Bundle args = new Bundle();
        args.putInt("num", mNum);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pager_list, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView) tv).setText(arrayListHere.get(mNum).tweet);
        ImageView imageView = v.findViewById(R.id.iv_share);
        imageView.setOnClickListener(this);
        return v;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, arrayListHere.get(mNum).tweet);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }
}
