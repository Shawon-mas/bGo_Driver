package com.app.bgodriver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bgodriver.R;
import com.app.bgodriver.model.ItemClick;

import java.util.List;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.MyViewHolder> {

    List<String> titles;
    LayoutInflater inflater;
    Context context;
    private final ItemClick itemClick;


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


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView_helpItem;

        public MyViewHolder(@NonNull View itemView,ItemClick itemClick) {
            super(itemView);

            textView_helpItem=itemView.findViewById(R.id.bGo_helpText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
}
