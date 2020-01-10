package com.USMS.Mobile.ui.student_side;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.USMS.Mobile.R;
import com.USMS.Mobile.models.NotificationItem;
import com.USMS.Mobile.models.NotificationItemAdapter;

import java.util.ArrayList;

public class StudentNotifFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NotificationItem> itemList;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_notif, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.notification_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<NotificationItem>();
        itemList.add(new NotificationItem("Notif 1", "body 1"));
        itemList.add(new NotificationItem("Notif 2", "body 2"));
        itemList.add(new NotificationItem("Notif 3", "body 3"));
        itemList.add(new NotificationItem("Notif 4", "body 4"));


        myAdapter = new NotificationItemAdapter(getActivity(), itemList);
        recyclerView.setAdapter(myAdapter);

    }
}
