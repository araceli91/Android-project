package org.elis.jp4application;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter{

    private LayoutInflater mInflter;
    private ArrayList<Food> data;

    private onQuantityChange onQuantityChange;

    public interface onQuantityChange{
        public void onItemAdded(double price);
        public void onItemRemoved(double price);
    }


    public FoodListAdapter (Context context, ArrayList<Food> data) {
        this.data = data;
        mInflter = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v =  mInflter.inflate(R.layout.row,viewGroup, false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        FoodViewHolder foodViewHolder = (FoodViewHolder)viewHolder;
        foodViewHolder.productName.setText(data.get(i).getName());
        foodViewHolder.productPrice.setText(""+data.get(i).getPrice());
        foodViewHolder.productQty.setText(""+data.get(i).getQuantita());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    private void addItem(){

    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public Button plus, minus;
        public TextView productName;
        public TextView productPrice;
        public TextView productQty;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.item_name);
            productPrice = itemView.findViewById(R.id.item_price);
            productQty = itemView.findViewById(R.id.productQty);
            }

        @Override
        public void onClick(View v) {

            if(itemView.getId()== R.id.plus){

                Food food = data.get(getAdapterPosition());
                food.increaseQuantita(notifyItemChanged());


                // addItem(data.get(getAdapterPosition()).getPrice(), data.get(getAdapterPosition()).getQuantita()),

            }
                else if (itemView.getId() == R.id.minus){
                Food food = data.get(getAdapterPosition());
                food.decreaseQuantita();
                notifyDataSetChanged();

            }
        }
    }

    private double notifyItemChanged()
    {
        return 0;
    }
}
