package com.example.tourguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {

    private Context context;
    private List<dataclass> dataList;

    public MyAdapter2(Context context, List<dataclass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item, parent, false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        Glide.with(context).load(dataList.get(position).getImageUri()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getTourTitle());
        holder.recReview.setText(dataList.get(position).getTourReview());
        holder.recPriority.setText(dataList.get(position).getTourDate());


        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity2.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getImageUri());
                intent.putExtra("Review", "Review: " + dataList.get(holder.getAdapterPosition()).getTourReview());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getTourTitle());
                intent.putExtra("Location", "Located: " + dataList.get(holder.getAdapterPosition()).getTourLocation());
                intent.putExtra("Cost", "Estimated Cost: " + dataList.get(holder.getAdapterPosition()).getTourCost());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getTourDescription());
                intent.putExtra("Contact", "Contact Info: " + dataList.get(holder.getAdapterPosition()).getTourContact());
                intent.putExtra("Genre", "Tour Type: " + dataList.get(holder.getAdapterPosition()).getTourGenre());
                intent.putExtra("Date", "Tour Start Date: " + dataList.get(holder.getAdapterPosition()).getTourDate());

                intent.putExtra("Key", dataList.get(holder.getAdapterPosition()).getKey());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<dataclass> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder2 extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTitle, recReview, recPriority;

    CardView recCard;
    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recReview = itemView.findViewById(R.id.recReview);
        recPriority = itemView.findViewById(R.id.recPriority);
        recTitle = itemView.findViewById(R.id.recTitle);




    }
}
