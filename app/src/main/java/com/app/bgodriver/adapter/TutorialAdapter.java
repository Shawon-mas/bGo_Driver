package com.app.bgodriver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.bgodriver.R;
import com.app.bgodriver.model.TutorialModel;

import java.util.ArrayList;

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TutorialModel> modelArrayList;

    public TutorialAdapter(Context context, ArrayList<TutorialModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tutorial_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TutorialModel tutorialModel=modelArrayList.get(position);
        holder.textView.setText(tutorialModel.getTitle());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tutorial_text);
        }
    }
}
/*
View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_reveiw_list,parent,false);
       MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder
 */