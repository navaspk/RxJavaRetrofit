package com.example.navaspk.nypopular.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navaspk.nypopular.NyPopularApplication;
import com.example.navaspk.nypopular.R;
import com.example.navaspk.nypopular.model.network.NyPopularService;
import com.example.navaspk.nypopular.presenter.PopularNews;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PopularHomeFragment extends Fragment {

    CustomRecyclerView mRecyclerView;
    PopularAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    private List<PopularNews> mSampleItemList;
    NyPopularService mPopularService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSampleItemList = new ArrayList<>();
        mPopularService = ((NyPopularApplication) getActivity().getApplication()).getRetrofit();
        Observable<PopularNews> observable = mPopularService.getAllSectionNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<PopularNews>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PopularNews popularNews) {
                mSampleItemList.add(popularNews);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (CustomRecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        //size lookup may be required
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PopularAdapter(getContext(), mSampleItemList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
