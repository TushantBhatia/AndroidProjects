package com.tushant.interfragmentcommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sanchal on 6/25/2017.
 */

public class FragmentB extends Fragment {
    TextView textView;
    String text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_b,container);
        textView = (TextView) v.findViewById(R.id.textview2);

        if (savedInstanceState != null && savedInstanceState.containsKey("KEY"))
        {
            String s= savedInstanceState.getString("KEY");
            textView.setText(s);
        }
        return v;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY",text);
    }

    public void changeText(String Text){
        this.text = Text;
        textView.setText(Text);
    }
}
