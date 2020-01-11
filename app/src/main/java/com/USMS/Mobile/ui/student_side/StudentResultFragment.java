package com.USMS.Mobile.ui.student_side;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.USMS.Mobile.R;
import com.USMS.Mobile.models.NotificationItem;
import com.USMS.Mobile.models.NotificationItemAdapter;
import com.USMS.Mobile.models.ResultItem;
import com.USMS.Mobile.models.ResultItemAdapter;

import java.util.ArrayList;

public class StudentResultFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ResultItem> itemList;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_result, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<ResultItem>();
        itemList.add(new ResultItem("Module 1", "att 1", "attTwo 1"));
        itemList.add(new ResultItem("Module 2", "att 2", "attTwo 2"));
        itemList.add(new ResultItem("Module 3", "att 3", "attTwo 3"));
        itemList.add(new ResultItem("Module 4", "att 4", "attTwo 4"));


        myAdapter = new ResultItemAdapter(getActivity(), itemList);
        recyclerView.setAdapter(myAdapter);


    }
}
