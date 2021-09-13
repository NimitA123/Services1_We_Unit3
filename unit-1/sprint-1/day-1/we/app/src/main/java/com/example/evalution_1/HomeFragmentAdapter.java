package com.example.evalution_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentViewHolder> {
    private List<ResponseModel> arrayList;
    public HomeFragmentAdapter(List<ResponseModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HomeFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new HomeFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentViewHolder holder, int position) {
        ResponseModel menu = arrayList.get(position);
        holder.setData(menu);

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }
}
