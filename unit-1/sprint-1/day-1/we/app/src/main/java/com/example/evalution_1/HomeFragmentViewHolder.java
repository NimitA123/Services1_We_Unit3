package com.example.evalution_1;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeFragmentViewHolder extends RecyclerView.ViewHolder {
    private ImageView  img;
    public HomeFragmentViewHolder(@NonNull View itemView) {

        super(itemView);
        img = itemView.findViewById(R.id.imageView);
    }
    public void setData(NowShowingModel responseModel){
        img.setImageResource(responseModel.getStoryline().charAt(i));
    }
   /****     if(responseModel.getNowShowing()!= null){
                   Glide.with(img).load(responseModel.getNowShowing()).into(img);
                 }
        else{
            img.setImageResource(R.drawable.img2);
        }
    }
****/
}
