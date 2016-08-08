package io.toru.imagesearching.network;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import io.toru.imagesearching.model.OriginalSearchingResultModel;
import io.toru.imagesearching.utility.Util;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toru on 2016. 8. 7..
 */
public class NetworkRestClient {
    private static final String TAG = NetworkRestClient.class.getSimpleName();

    private static ISearchingApi searchingApi;
    private static String baseUrl = "https://apis.daum.net/";

    public static ISearchingApi getSearchingApi(){
        if (searchingApi == null) {
            OkHttpClient okClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Response response = chain.proceed(chain.request());
                            return response;
                        }
                    })
                    .build();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            searchingApi  = client.create(ISearchingApi.class);
        }
        return searchingApi;
    }

    public static void getSearchResult(String query, final ISearchResultListener resultListener){
        ISearchingApi service = NetworkRestClient.getSearchingApi();
        Call<OriginalSearchingResultModel> call = service.getQueriedImageList(Util.API_KEY, query);
        call.enqueue(new Callback<OriginalSearchingResultModel>() {
            @Override
            public void onResponse(Call<OriginalSearchingResultModel> call, retrofit2.Response<OriginalSearchingResultModel> response) {
                OriginalSearchingResultModel result = response.body();
                Log.w(TAG, "onResponse: message::" + response.code());
                Log.w(TAG, "onResponse: message::" + response.message());
                Log.d("MainActivity", "response = " + new Gson().toJson(result));
                resultListener.onSearchEnd(result.getChannel().getItem());
            }

            @Override
            public void onFailure(Call<OriginalSearchingResultModel> call, Throwable t) {
                try {
                    Log.e(TAG, t.getMessage());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
