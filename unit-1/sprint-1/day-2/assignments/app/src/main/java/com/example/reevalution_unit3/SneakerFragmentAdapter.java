package com.example.reevalution_unit3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Iterator;
import java.util.List;

public class SneakerFragmentAdapter extends RecyclerView.Adapter<SneakerFragmentViewHolder> {
    private List<ResponseDTO> list;
    private ItemClickListener itemClickListener;
    public SneakerFragmentAdapter(List<ResponseDTO> list, ItemClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SneakerFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new SneakerFragmentViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SneakerFragmentViewHolder holder, int position) {
        ResponseDTO responseDTO = list.get(position);
        holder.setData(responseDTO);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
