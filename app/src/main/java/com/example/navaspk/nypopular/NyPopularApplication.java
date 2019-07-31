package com.example.navaspk.nypopular;

import android.app.Application;
import android.content.Context;

import com.example.navaspk.nypopular.model.AppPreferences;
import com.example.navaspk.nypopular.model.network.NetworkConstants;
import com.example.navaspk.nypopular.model.network.NyPopularService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NyPopularApplication extends Application {

    NyPopularService mNyPopularService;

    @Override
    public void onCreate() {
        super.onCreate();
        getRetrofit();
    }

    public NyPopularService getRetrofit() {
        if (mNyPopularService == null)
            mNyPopularService = ApiServiceFactory.initiatePopularService(this, new AppPreferences());
        return mNyPopularService;
    }

    static class ApiServiceFactory {

        static NyPopularService initiatePopularService(Context context,
                                                       AppPreferences appPreferences) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(NetworkConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(NyPopularService.class);
        }

    }
}
