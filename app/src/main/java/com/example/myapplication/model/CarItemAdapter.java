package com.example.myapplication.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Scene04;
import com.example.myapplication.classes.Car;

import java.util.List;

public class CarItemAdapter extends RecyclerView.Adapter<CarItemAdapter.CarItemViewHolder> {
    private final List<Car> cars;

    public CarItemAdapter(List<Car> carItens) {
        this.cars = carItens;
    }



    @NonNull
    @Override
    public CarItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);
        return new CarItemViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull CarItemViewHolder holder, int position) {
        Car item = cars.get(position);
        holder.bind(item);
    }
    @Override
    public int getItemCount() {
        return cars.size();
    }

    static class CarItemViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView title;
        TextView price;
        TextView star1;
        TextView star2;
        TextView star3;
        TextView star4;
        TextView star5;
        TextView picture;
        TextView door;
        TextView bagged;

        public CarItemViewHolder(@NonNull View itemView) {
            super(itemView);
            try {
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
            } catch (Exception e){}
        }
        public void bind(Car item) {
            try {
                id.setText(item.id);
                title.setText(item.title);
                door.setText(String.valueOf(item.door));
                bagged.setText(String.valueOf(item.bagged));
                price.setText(String.valueOf(item.price));
                switch (item.star){
                    case 5:
                        star5.setBackgroundColor(1);
                        break;
                    case 4:
                        star4.setBackgroundColor(1);
                        break;
                    case 3:
                        star3.setBackgroundColor(1);
                        break;
                    case 2:
                        star2.setBackgroundColor(1);
                        break;
                    case 1:
                        star1.setBackgroundColor(1);
                        break;
                }
            } catch (Exception e){}
        }
    }
}