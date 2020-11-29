package com.example.wisnu.adapter;

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
import com.example.wisnu.DetailWisata;
import com.example.wisnu.R;
import com.example.wisnu.model.WisataItem;

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {
    private ArrayList<WisataItem> mWisataData;
    private Context mContext;

    public WisataAdapter(ArrayList<WisataItem> mWisataData, Context mContext) {
        this.mWisataData = mWisataData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_wisata, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTitleText.setText(mWisataData.get(position).getNama());
        Glide.with(mContext).load(mWisataData.get(position).getGambarUrl()).error(R.mipmap.ic_wisnu).override(512, 512).into(holder.mWisataImage);
        holder.cardClick.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetailWisata.class);
            intent.putExtra("nama", mWisataData.get(position).getNama());
            intent.putExtra("kategori", mWisataData.get(position).getKategori());
            intent.putExtra("gambarUrl", mWisataData.get(position).getGambarUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mWisataData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleText;
        private ImageView mWisataImage;
        private CardView cardClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.wisataTitle);
            mWisataImage = itemView.findViewById(R.id.wisataImage);
            cardClick = itemView.findViewById(R.id.cardClick);
        }
    }
}