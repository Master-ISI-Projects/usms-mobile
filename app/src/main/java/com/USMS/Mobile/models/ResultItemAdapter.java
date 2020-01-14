package com.USMS.Mobile.models;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.USMS.Mobile.R;

import java.util.ArrayList;

public class ResultItemAdapter  extends RecyclerView.Adapter<ResultItemAdapter.ViewHolder>  {

    private ArrayList<ResultItem> results;

    public  ResultItemAdapter(Context context, ArrayList resultsItems){
        results = resultsItems;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView result_module, result_attOne, result_attTwo;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            result_attOne = itemView.findViewById(R.id.result_attOne);
            result_attTwo = itemView.findViewById(R.id.result_attTwo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a =  results.indexOf((ResultItem) v.getTag());
                    String b = a + "e";
                    Log.i("ok", b);
                }
            });
        }
    }
    @NonNull
    @Override
    public ResultItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_list_item, viewGroup, false);
        return new ResultItemAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultItemAdapter.ViewHolder Viewholder, int i) {

        Viewholder.itemView.setTag(results.get(i));
        Viewholder.result_attOne.setText(results.get(i).getAttOne());
        Viewholder.result_attTwo.setText(results.get(i).getAttTwo());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
