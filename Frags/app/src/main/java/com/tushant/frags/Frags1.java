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

public class Frags1 extends android.support.v4.app.Fragment {
    public static Frags1 newInstance(int count)

    {
        Bundle args = new Bundle();
        args.putInt("count", count);
        Frags1 fragment = new Frags1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frags_1,container,false);
        ((TextView)v.findViewById(R.id.textblue)).setText(""+getArguments().getInt("count"));
        return v;
    }
}

