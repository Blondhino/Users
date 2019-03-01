package com.blondi.lv2;

import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Enio on 12/3/2018.
 */

public class RecyclerVewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<String> NameList = new ArrayList<>();

    private List<String> TimeList = new ArrayList<>();

    private CellClickListener clickListener;
    

    private int[] Images= new int []{
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
    };
    public  RecyclerVewAdapter(CellClickListener listener){this.clickListener=listener;}


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cellVIew = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell,parent,false);
        return new ViewHolder(cellVIew, clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder ViewHolder, int position) {
        ViewHolder.setName(NameList.get(position));
        ViewHolder.setImage(Images[(position+1)%5]);
        ViewHolder.setTimeStamp(TimeList.get(position));
    }

    @Override
    public int getItemCount() {
        return NameList.size();
    }


    public void addNewCell(String name, String time){
        TimeList.add(NameList.size(),time);
        NameList.add(NameList.size(),name);
        notifyItemInserted(NameList.size());


    }

    public void removeCell(int position){
        TimeList.remove(position);
        NameList.remove(position);
        notifyItemRemoved(position);
    }


}
