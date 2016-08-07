package io.toru.imagesearching.network;

import io.toru.imagesearching.model.OriginalSearchingResultModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by toru on 2016. 8. 7..
 */
public interface ISearchingApi {
//    https://apis.daum.net/search/image?apikey={apikey}&q=다음카카오&output=json
    @Headers({
//        "Accept: application/vnd.yourapi.v1.full+json",
        "User-Agent:android"
    })
    @GET("search/image?apikey=0fe27a3739407cb2ba22e0cf0a698a6d&output=json")
    Call<OriginalSearchingResultModel> getQueriedImageList(@Query("q") String searchImageQuery);
}