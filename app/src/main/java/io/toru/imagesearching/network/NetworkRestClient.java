package io.toru.imagesearching.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toru on 2016. 8. 7..
 */
public class NetworkRestClient {

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
}
