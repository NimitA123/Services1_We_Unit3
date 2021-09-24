package com.example.evalution_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeFragmentViewHolder extends RecyclerView.ViewHolder {
    private ImageView img;

    public HomeFragmentViewHolder(@NonNull View itemView) {

        super(itemView);
        img = itemView.findViewById(R.id.imagePoster);
    }

    public void setData(NowShowingModel responseModel) {

  if(responseModel.getPosterurl()!= null){

        Glide.with(img).load(responseModel.getPosterurl()).into(img);
    }
  else{
    img.setImageResource(R.drawable.img2);
  }
    }

}
