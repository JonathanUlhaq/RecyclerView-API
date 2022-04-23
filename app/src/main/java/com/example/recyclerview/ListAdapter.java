package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    Football football[];

    public ListAdapter(Football[] football) {
        this.football = football;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.name.setText(football[position].getName());
        holder.city.setText(football[position].getCity());
        Glide.with(holder.name.getContext()).load(football[position].getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return football.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name,city;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.gambar);
            name = itemView.findViewById(R.id.judul);
            city = itemView.findViewById(R.id.deskripsi);
        }
    }
}
