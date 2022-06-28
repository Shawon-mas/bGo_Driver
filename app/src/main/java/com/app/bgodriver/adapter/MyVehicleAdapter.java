package com.app.bgodriver.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bgodriver.R;
import com.app.bgodriver.model.MyVehicleModel;
import com.google.android.material.card.MaterialCardView;


import java.util.ArrayList;

public class MyVehicleAdapter extends RecyclerView.Adapter<MyVehicleAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<MyVehicleModel> myVehicleModelArrayList;
    int index=0;


    public MyVehicleAdapter(Context context, ArrayList<MyVehicleModel> myVehicleModelArrayList) {
        this.context = context;
        this.myVehicleModelArrayList = myVehicleModelArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_vehicle,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
       MyVehicleModel myVehicleModel= myVehicleModelArrayList.get(position);
       holder.imageView_myVehicleImage.setImageResource(myVehicleModel.getMyVehicleImage());
       holder.textView_myVehicleModel.setText(myVehicleModel.getMyVehicleModel());
       holder.textView_myVehicleNumber.setText(myVehicleModel.getMyVehicleNumber());
       holder.materialCardView.setOnClickListener(v -> {

               holder.imageView_myVehicleSelect.setVisibility(View.VISIBLE);

       });



    }

    @Override
    public int getItemCount() {
        return myVehicleModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_myVehicleImage,imageView_myVehicleSelect;
        TextView textView_myVehicleModel,textView_myVehicleNumber;
        MaterialCardView materialCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_myVehicleImage=itemView.findViewById(R.id.myVehicle_image);
            imageView_myVehicleSelect=itemView.findViewById(R.id.myVehicle_select);
            textView_myVehicleModel=itemView.findViewById(R.id.myVehicle_name);
            textView_myVehicleNumber=itemView.findViewById(R.id.myVehicle_number);
            materialCardView=itemView.findViewById(R.id.myVehicle_cardBg);

        }
    }
}
