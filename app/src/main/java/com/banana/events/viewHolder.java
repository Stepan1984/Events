package com.banana.events;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class viewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    ImageView Image_View;
    View itemView;

    public viewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.Text_View);
        Image_View =itemView.findViewById(R.id.Image_View);

        this.itemView = itemView;
    }

}

