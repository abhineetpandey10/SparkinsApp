package com.sparkee.sparkinsapp;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MyViewHolder> {

    ArrayList<MedicineHelper> mlist;
    Context context;

    public MedicineAdapter(Context context,ArrayList<MedicineHelper> mlist){
        this.mlist=mlist;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.medicard,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MedicineHelper medihelp= mlist.get(position);
        holder.medicinename.setText(medihelp.getMedicinename());
        holder.medicinedesc.setText(medihelp.getMedicinedesc());
        holder.medicinepriority.setText(Integer.toString(medihelp.getMedicinepriority()));
       

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView medicinename,medicinedesc,medicinepriority;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            medicinename= itemView.findViewById(R.id.title_single_med);
            medicinedesc=itemView.findViewById(R.id.desc_single_med);
            medicinepriority=itemView.findViewById(R.id.prior);



        }
    }

}
