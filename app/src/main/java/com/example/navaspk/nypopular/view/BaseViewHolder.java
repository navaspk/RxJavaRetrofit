package com.example.navaspk.nypopular.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navaspk.nypopular.R;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private TextView mHeading;
    private TextView mSummary;
    private TextView mAuthor;
    private TextView mDate;

    private ImageView mProfile;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mHeading = itemView.findViewById(R.id.heading);
        mSummary = itemView.findViewById(R.id.summary);
        mAuthor = itemView.findViewById(R.id.author);
        mDate = itemView.findViewById(R.id.date);
        mProfile = itemView.findViewById(R.id.profile_img);
    }
}
