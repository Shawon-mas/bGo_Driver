package com.app.bgodriver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bgodriver.R;
import com.app.bgodriver.model.BidingItemClick;
import com.app.bgodriver.model.TripModel;
import com.app.bgodriver.model.VehicleListModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<VehicleListModel> vehicleListModelArrayList;


    public VehicleListAdapter(Context context, ArrayList<VehicleListModel> vehicleListModelArrayList) {
        this.context = context;
        this.vehicleListModelArrayList = vehicleListModelArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_list_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VehicleListModel vehicleListModel= vehicleListModelArrayList.get(position);
        holder.textView_vehicleName.setText(vehicleListModel.getVehicleName());
        holder.textView_vehicleNumber.setText(vehicleListModel.getVehicleNumber());
        holder.textView_vehicleModel.setText(vehicleListModel.getVehicleModel());
        holder.textView_vehicleColor.setText(vehicleListModel.getVehicleColor());
        holder.textView_vehicleSit.setText(vehicleListModel.getVehicleSit());
        holder.textView_vehicleAirCondition.setText(vehicleListModel.getVehicleAirCondition());
      //  holder.textView_vehicleStatus.setText(vehicleListModel.getVehicleStatus());
        if (vehicleListModel.getVehicleStatus().equals("true"))
        {
            holder.textView_vehicleStatus.setText(R.string.car_status);
        }else {
            holder.textView_vehicleStatus.setText(R.string.car_pending);
        }


    }

    @Override
    public int getItemCount() {
        return vehicleListModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_vehicleName,textView_vehicleNumber,textView_vehicleColor,textView_vehicleModel,
                textView_vehicleSit,textView_vehicleAirCondition,textView_vehicleStatus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           textView_vehicleName=itemView.findViewById(R.id.vehicle_name);
            textView_vehicleNumber=itemView.findViewById(R.id.vehicle_number);
            textView_vehicleColor=itemView.findViewById(R.id.vehicle_color);
            textView_vehicleSit=itemView.findViewById(R.id.vehicle_sit);
            textView_vehicleAirCondition=itemView.findViewById(R.id.vehicle_acType);
            textView_vehicleStatus=itemView.findViewById(R.id.vehicle_status);
            textView_vehicleModel=itemView.findViewById(R.id.vehicle_model);


        }
    }
}
