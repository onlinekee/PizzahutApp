package com.example.hp.pizzahut_order;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
//    private int[] images;
//
//    public RecyclerAdapter(int[] images){
//        this.images = images;
//    }
//    @NonNull
//    @Override
//    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from( viewGroup.getContext()).inflate(R.layout.activity_searchresult,viewGroup,false);
//        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
//        return imageViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {
//            int image_id = images[i];
//            viewHolder.album.setImageResource(image_id);
//            viewHolder.albumTitle.setText("Image :"+i);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return images.length;
//    }
//
//    public static class ImageViewHolder extends ViewHolder{
//
//        ImageView album;
//        TextView albumTitle;
//        public ImageViewHolder(@NonNull View itemView) {
//            super(itemView);
//            album = itemView.findViewById(R.id.album);
//            albumTitle = itemView.findViewById(R.id.album_title);
//
//        }
//    }
//}
