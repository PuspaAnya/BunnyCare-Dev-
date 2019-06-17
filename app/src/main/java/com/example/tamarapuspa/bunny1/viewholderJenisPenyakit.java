package com.example.tamarapuspa.bunny1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class viewholderJenisPenyakit extends RecyclerView.ViewHolder {

    View mView;

    public viewholderJenisPenyakit(View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
        //item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick (View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });

    }

    //set details to recycler view row
    public void setDetails(Context ctx, String title, String description, String image){
        //Views
        TextView mTitleTv = mView.findViewById(R.id.tv_title);
        TextView mDetailTv = mView.findViewById(R.id.tv_desc);
        ImageView mImageIv = mView.findViewById(R.id.iv_image);

        //set data to views
        mTitleTv.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageIv);
    }

    private viewholderJenisPenyakit.ClickListener mClickListener;

    //interface to send callbacks
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(viewholderJenisPenyakit.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
