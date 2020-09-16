package com.ninja.vegitapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Callback;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<VegD> vegList;
    private OnVegListener onVegListener;


    public RecyclerAdapter(ArrayList<VegD> vegDList,  OnVegListener onVegListener){
        this.vegList = vegDList;
        this.onVegListener = onVegListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView price;
        OnVegListener onVegListener;

        public MyViewHolder(final View view,OnVegListener onVegListener){
            super(view);
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            this.onVegListener = onVegListener;
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onVegListener.onVegClick(getAdapterPosition());
        }
    }


    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new MyViewHolder(itemView,onVegListener);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder myViewHolder, int position) {
        String name = vegList.get(position).getName();
        String price = vegList.get(position).getPrice();
        myViewHolder.name.setText(name);
        myViewHolder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return vegList.size();
    }

    public interface OnVegListener{
        void onVegClick(int position);
    }

}
