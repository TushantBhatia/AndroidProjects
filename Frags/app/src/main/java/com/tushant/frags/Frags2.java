package com.tushant.frags;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sanchal on 6/19/2017.
 */

public class Frags2 extends android.support.v4.app.Fragment {
    public static Frags2 newInstance(int count)

    {
        Bundle args = new Bundle();
        args.putInt("count", count);
        Frags2 fragment = new Frags2();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_2,container,false);
        ((TextView)v.findViewById(R.id.textgreen)).setText(""+getArguments().getInt("count"));
        return v;
    }
}
