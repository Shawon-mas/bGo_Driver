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
import com.app.bgodriver.model.DriverModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<DriverModel> driverModelArrayList;

    public DriverAdapter(Context context, ArrayList<DriverModel> driverModelArrayList) {
        this.context = context;
        this.driverModelArrayList = driverModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_list_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DriverModel driverModel= driverModelArrayList.get(position);
        holder.circleImageView.setImageResource(driverModel.getImg());
        holder.textView_name.setText(driverModel.getName());
        holder.textView_licenceNo.setText(driverModel.getLicenceNo());
        holder.textView_expireDate.setText(driverModel.getExpireDate());
        holder.textView_phoneNumber.setText(driverModel.getPhoneNumber());
        holder.textView_address.setText(driverModel.getAddress());

        if (driverModel.getVerified().equals("true"))
        {
            holder.imageView.setVisibility(View.VISIBLE);
        }else {
            holder.imageView.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return driverModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        ImageView imageView;
        TextView textView_name,textView_licenceNo,textView_expireDate,textView_phoneNumber,textView_address;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.Driverprofile_image);
            textView_name=itemView.findViewById(R.id.driver_name);
            textView_licenceNo=itemView.findViewById(R.id.driver_drivingLicenceNo);
            textView_expireDate=itemView.findViewById(R.id.expireDate);
            textView_phoneNumber=itemView.findViewById(R.id.driver_phoneNumber);
            textView_address=itemView.findViewById(R.id.driver_address);
            imageView=itemView.findViewById(R.id.driverVerify);
        }
    }
}
