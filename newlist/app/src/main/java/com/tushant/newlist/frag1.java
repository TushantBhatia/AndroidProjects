package com.tushant.newlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.jar.Attributes;

/**
 * Created by sanchal on 6/23/2017.
 */

public class frag1 extends Fragment{
    public static frag1 newInstance(String name,String age,String course)
    {
        Bundle args = new Bundle();
        args.putString("Name",name);
        args.putString("Age",age);
        args.putString("course",course);
        frag1 fragment = new frag1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frags_1,container,false);
        Bundle b = getArguments();

        TextView name,course,age;
        //((TextView)v.findViewById(R.id.)).setText(""+getArguments().getInt("count"));
        return v;
    }

}
