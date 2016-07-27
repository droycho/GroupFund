package com.epicodus.groupfund.services;

import com.epicodus.groupfund.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by DJRoy on 7/27/16.
 */
public class TravelbriefingService {
    public static void findCountries(String country, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TRAVELBRIEFING_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.TRAVELBRIEFING_COUNTRY_QUERY_PARAMETER, country + "?format=json");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
