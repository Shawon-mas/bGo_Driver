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
import com.app.bgodriver.model.TripModel;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TripModel> tripModelArrayList;

    public TripAdapter(Context context, ArrayList<TripModel> tripModelArrayList) {
        this.context = context;
        this.tripModelArrayList = tripModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TripModel tripModel=tripModelArrayList.get(position);
        holder.view_carImage.setImageResource(tripModel.getCarImage());
        holder.textView_destination.setText(tripModel.getDestinationLocation());
        holder.textView_currentLocation.setText(tripModel.getCurrentLocation());
        holder.textView_tripTime.setText(tripModel.getTripTime());
        holder.textView_roundTrip.setText(tripModel.getRoundTrip());
        holder.textView_passengers.setText(tripModel.getTripPassenger()+" peoples");
        holder.textView_airCondition.setText(tripModel.getAirCondition());

    }

    @Override
    public int getItemCount() {
        return tripModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView view_carImage;
        TextView textView_destination,textView_currentLocation,textView_tripTime,
                textView_roundTrip,textView_passengers,textView_airCondition;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_carImage=itemView.findViewById(R.id.image_icon);
            textView_destination=itemView.findViewById(R.id.trip_destination);
            textView_currentLocation=itemView.findViewById(R.id.trip_currentLocation);
            textView_tripTime=itemView.findViewById(R.id.trip_date);
            textView_roundTrip=itemView.findViewById(R.id.trip_round);
            textView_passengers=itemView.findViewById(R.id.trip_passenger);
            textView_airCondition=itemView.findViewById(R.id.trip_acType);
        }
    }
}
