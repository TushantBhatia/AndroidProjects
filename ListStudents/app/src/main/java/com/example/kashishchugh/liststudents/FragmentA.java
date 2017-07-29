package com.example.kashishchugh.liststudents;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kashish chugh on 21-Jun-17.
 */

public class FragmentA extends Fragment{

    public static FragmentA newInstance(String a,String b,String c){
        Bundle args = new Bundle();
        args.putString("name",a);
        args.putString("age",b);
        args.putString("course",c);
        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.single_list_info,container,false);
        ((TextView)v.findViewById(R.id.name)).setText(getArguments().getString("name"));
        ((TextView)v.findViewById(R.id.age)).setText(getArguments().getString("age"));
        ((TextView)v.findViewById(R.id.course)).setText(getArguments().getString("course"));
        return v;
    }

}
