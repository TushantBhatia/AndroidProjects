package com.tushant.interfragmentcommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sanchal on 6/25/2017.
 */

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_a,container);

        Button button = (Button) v.findViewById(R.id.buttonFragmentA);
        final EditText editText = (EditText)v.findViewById(R.id.edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 =editText.getText().toString();
                Communicator communicator = (Communicator) getActivity();
                communicator.addText(s1);

            }
        });
        return v;
    }
}
