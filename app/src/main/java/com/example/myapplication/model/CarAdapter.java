package com.example.myapplication.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.classes.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
    Context context;
    List<Car> cars;
    private RecycleViewInterface recycleViewInterface;

    public CarAdapter (Context context, List<Car> cars, RecycleViewInterface recycleViewInterface){
        this.context = context;
        this.cars = cars;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.car_list_item, parent, false);
        return new CarAdapter.MyViewHolder(view, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(cars.get(position).getId()));
        holder.title.setText(cars.get(position).getTitle());
        holder.price.setText(String.valueOf(cars.get(position).getPrice()));

        holder.star1.setImageResource(R.drawable.ic_baseline_star_24);
        holder.star2.setImageResource(R.drawable.ic_baseline_star_24);
        holder.star3.setImageResource(R.drawable.ic_baseline_star_24);
        holder.star4.setImageResource(R.drawable.ic_baseline_star_24);
        holder.star5.setImageResource(R.drawable.ic_baseline_star_24);
        if (cars.get(position).star == 5){
            holder.star1.setColorFilter(Color.rgb(255,255,0));
            holder.star2.setColorFilter(Color.rgb(255,255,0));
            holder.star3.setColorFilter(Color.rgb(255,255,0));
            holder.star4.setColorFilter(Color.rgb(255,255,0));
            holder.star5.setColorFilter(Color.rgb(255,255,0));
        } else if (cars.get(position).star == 4){
            holder.star1.setColorFilter(Color.rgb(255,255,0));
            holder.star2.setColorFilter(Color.rgb(255,255,0));
            holder.star3.setColorFilter(Color.rgb(255,255,0));
            holder.star4.setColorFilter(Color.rgb(255,255,0));
        } else if (cars.get(position).star == 3){
            holder.star1.setColorFilter(Color.rgb(255,255,0));
            holder.star2.setColorFilter(Color.rgb(255,255,0));
            holder.star3.setColorFilter(Color.rgb(255,255,0));
        } else if (cars.get(position).star == 2){
            holder.star1.setColorFilter(Color.rgb(255,255,0));
            holder.star2.setColorFilter(Color.rgb(255,255,0));
        } else if (cars.get(position).star == 1){
            holder.star1.setColorFilter(Color.rgb(255,255,0));
        }

        holder.door.setText(String.valueOf(cars.get(position).getDoor()));
        holder.bagged.setText(String.valueOf(cars.get(position).getDoor()));
        if (cars.get(position).model == 1){
            holder.img.setImageResource(R.mipmap.a1);
        } else if (cars.get(position).model == 2){
            holder.img.setImageResource(R.mipmap.a2);
        } else if (cars.get(position).model == 3){
            holder.img.setImageResource(R.mipmap.a3);
        } else if (cars.get(position).model == 4){
            holder.img.setImageResource(R.mipmap.a4);
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView title;
        TextView price;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        TextView door;
        TextView bagged;
        ImageView img;

        public MyViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);

            id = itemView.findViewById(R.id.car_id);
            title = itemView.findViewById(R.id.car_title);
            door = itemView.findViewById(R.id.car_door_amount);
            bagged = itemView.findViewById(R.id.car_bagged_amount);
            price = itemView.findViewById(R.id.car_cost);
            star1 = itemView.findViewById(R.id.car_star1);
            star2 = itemView.findViewById(R.id.car_star2);
            star3 = itemView.findViewById(R.id.car_star3);
            star4 = itemView.findViewById(R.id.car_star4);
            star5 = itemView.findViewById(R.id.car_star5);
            img = itemView.findViewById(R.id.car_image);
            itemView.findViewById(R.id.recycleObj).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleViewInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recycleViewInterface.OnItemClick(position);
                        }
                    }
                }
            });


        }
    }
}
