package com.example.quizzapplicationv1.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapplicationv1.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView surname;
    public TextView ph_no;
    public ImageView name;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        name = (ImageView)itemView.findViewById(R.id.contact_name);
        surname = (TextView) itemView.findViewById(R.id.contact_surname);
        ph_no = (TextView)itemView.findViewById(R.id.ph_no);
}
}
