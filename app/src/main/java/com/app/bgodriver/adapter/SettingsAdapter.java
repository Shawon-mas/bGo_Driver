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
import com.app.bgodriver.model.SettingsModel;

import java.util.ArrayList;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<SettingsModel> settingsModels;

    public SettingsAdapter(Context context, ArrayList<SettingsModel> settingsModels) {
        this.context = context;
        this.settingsModels = settingsModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_item_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SettingsModel settingsModel=settingsModels.get(position);
        holder.imageView_settings.setImageResource(settingsModel.getImage());
        holder.textView_settings.setText(settingsModel.getTitle());

    }

    @Override
    public int getItemCount() {
        return settingsModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_settings;
        TextView textView_settings;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_settings=itemView.findViewById(R.id.settings_icon);
            textView_settings=itemView.findViewById(R.id.settings_text);
        }
    }
}
