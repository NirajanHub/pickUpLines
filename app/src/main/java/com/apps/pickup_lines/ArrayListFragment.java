package com.apps.pickup_lines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ArrayListFragment extends Fragment {
    int mNum;
    static ArrayList<Model> arrayListHere;

    static ArrayListFragment newInstance(ArrayList arrayList,int mNum) {
        ArrayListFragment f = new ArrayListFragment();
        arrayListHere=arrayList;
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

        View v=inflater.inflate(R.layout.fragment_pager_list,container,false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText(arrayListHere.get(mNum).tweet);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item));
    }

    /*@Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.i("FragmentList", "Item clicked: " + id);
    }*/
}
