package com.alfianyusufabdullah.erecyclerview;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by jonesrandom on 3/6/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class Adapter extends RecyclerView.Adapter<Adapter.HolderGambar> {

    private List<Uri> data;

    public Adapter(List<Uri> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HolderGambar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image , parent , false);
        return new HolderGambar(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderGambar holder, int position) {
        holder.setContent(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HolderGambar extends RecyclerView.ViewHolder {

        ImageView rowImage;
        TextView rowText;

        HolderGambar(View itemView) {
            super(itemView);

            rowImage = itemView.findViewById(R.id.rowImage);
            rowText = itemView.findViewById(R.id.rowText);
        }

        void setContent(Uri uri) {

            Glide.with(itemView.getContext()).load(uri).into(rowImage);
            rowText.setText(uri.getLastPathSegment());
        }

    }
}
