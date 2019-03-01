package com.blondi.lv2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Enio on 12/3/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    private TextView userName;
    private ImageView userImage;
    private TextView TimeStamp;
    private ImageView DeleteImg;
    private CellClickListener clickListener;

    public ViewHolder(View itemView, CellClickListener listener){
        super(itemView);
        userName=itemView.findViewById(R.id.TvName);
        userImage=itemView.findViewById(R.id.IvUserImage);
        TimeStamp=itemView.findViewById(R.id.TvTime);
        DeleteImg=itemView.findViewById(R.id.IvRemove);
        clickListener = listener;
        //itemView.setOnClickListener(this);   ovo bi postavilo listener na cijelu celiju



        DeleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onDeleteClick(getAdapterPosition());
            }
        });
    }




    public void setName(String name){

        userName.setText(name);
    }

    public void setImage(int id){

        userImage.setImageResource(id);
    }

    public void setTimeStamp(String time){
        String currentTime= "Added at: " + time;
        TimeStamp.setText(currentTime);
    }


    @Override
    public void onClick(View view) {
        clickListener.onDeleteClick(getAdapterPosition());
    }
}
