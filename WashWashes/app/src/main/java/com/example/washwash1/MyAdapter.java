package com.example.washwash1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    String name[], time[];
    int images[];
    Context context;
    public static final String TAG = "Logcat";

    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        this.name = s1;
        this.time = s2;
        this.images = img;
    }

    public void update(){
        this.name = Firebase.getArray("names").toArray(new String [0]);
        this.time = Firebase.getArray("time").toArray(new String[0]);
        this.images = Machines.images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String machine_name = Firebase.getMachine();
        // logic for setting machine name as "Washer"/"Dryer" + number ??
        holder.text1.setText(machine_name.substring(0, machine_name.length()-1) + " "+  name[position]);
        holder.text2.setText(time[position]);
        // logic for setting each washer colour based on time remaining?
        int time_left = Integer.valueOf(time[position].substring(0,time[position].length()-4));
        if (time_left <= 0){
            holder.images.setImageResource(images[2]);
        }
        else if(time_left <= 10){
            holder.images.setImageResource(images[1]);
        }
        else{
            holder.images.setImageResource(images[0]);
        }

    }

    @Override
    public int getItemCount() {
        return time.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2;
        ImageView images;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.image1);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
}
