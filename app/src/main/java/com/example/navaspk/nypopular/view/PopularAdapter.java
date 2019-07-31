package com.example.navaspk.nypopular.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navaspk.nypopular.R;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    Context mContext;
    List mSampleList;

    PopularAdapter(Context context, List sampleList) {
        mContext = context;
        mSampleList = sampleList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.each_item, null);
        return new BaseViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        //
    }

    @Override
    public int getItemCount() {
        return mSampleList.size();
    }
}
