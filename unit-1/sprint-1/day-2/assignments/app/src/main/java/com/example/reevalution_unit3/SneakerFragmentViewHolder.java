package com.example.reevalution_unit3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SneakerFragmentViewHolder extends RecyclerView.ViewHolder {
    private ImageView img;
    private TextView tv;
    private TextView tv1;
    private CardView cardView;
    private ItemClickListener itemClickListener;

    public SneakerFragmentViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        img = itemView.findViewById(R.id.image);
        tv = itemView.findViewById(R.id.tvprice);
        tv1 = itemView.findViewById(R.id.tvName);
        this.itemClickListener = itemClickListener;
        cardView = itemView.findViewById(R.id.CardView);

    }
    public void setData(ResponseDTO responseDTO){
        if(responseDTO!= null){
          Glide.with(img).load(responseDTO.getMedia().getImageUrl()).into(img);
         tv.setText(responseDTO.getRetailPrice()+" ");
            tv1.setText(responseDTO.getBrand().toString());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.OnItemClick(responseDTO, getAdapterPosition());
                }
            });
        }
    }

}
