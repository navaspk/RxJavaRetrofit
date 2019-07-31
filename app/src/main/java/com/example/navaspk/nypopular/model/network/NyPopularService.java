package com.example.navaspk.nypopular.model.network;

import com.example.navaspk.nypopular.presenter.PopularNews;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NyPopularService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?apikey=sample-key")
    Observable<PopularNews> getAllSectionNews();
}
