package com.tushant.whatsapplayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by sanchal on 6/25/2017.
 */

public class ChatFragment extends Fragment {
    ArrayList<Chat> chatArrayList = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_chat,container,false);
        chatArrayList.add(new Chat("Tushant","Hello","5;30"));
        chatArrayList.add(new Chat("Tushan1t","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant2","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant3","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant4","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant5","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant6","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant7","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant8","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant9","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant10","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant11","Hello","5;30"));
        chatArrayList.add(new Chat("Tushant12","Hello","5;30"));

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.chatFragmentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ChatAdapter chatAdapter = new ChatAdapter(chatArrayList);
        recyclerView.setAdapter(chatAdapter);
        return v;
    }
}
