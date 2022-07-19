package com.app.bgodriver.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bgodriver.R;
import com.app.bgodriver.model.ItemClick;
import com.app.bgodriver.view.homeFragmentsUi.homeChildFragmentUi.AvailableTrips;

import java.util.List;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.MyViewHolder> {

    List<String> titles;
    LayoutInflater inflater;
    Context context;
    private final ItemClick itemClick;
     int index=-1;
     int pos;


    public HelpAdapter(List<String> titles, Context context, ItemClick itemClick) {
        this.titles = titles;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.itemClick = itemClick;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bgohelp_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view,itemClick);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView_helpItem.setText(titles.get(position));

     if (index==position)
     {
         holder.textView_helpItem.setBackgroundColor(context.getResources().getColor(R.color.bGo_mainColor));

     }else {
         holder.textView_helpItem.setBackground(context.getResources().getDrawable(R.drawable.input_bg));

     }

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_helpItem;
        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView,ItemClick itemClick) {
            super(itemView);

            textView_helpItem=itemView.findViewById(R.id.bGo_helpText);
            layout=itemView.findViewById(R.id.layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setSingleSelection(getAdapterPosition());

                    if (itemClick!=null)
                    {

                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION)
                        {
                            itemClick.onItemClick(pos);
                        }
                    }

                }
            });
        }
    }

    private void setSingleSelection(int adapterPosition) {
        if (adapterPosition==RecyclerView.NO_POSITION) return;
        notifyItemChanged(index);
        index=adapterPosition;
        notifyItemChanged(index);
    }
}
