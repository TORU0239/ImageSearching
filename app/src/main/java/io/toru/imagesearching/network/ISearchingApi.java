package io.toru.imagesearching.network;

import io.toru.imagesearching.model.OriginalSearchingResultModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by toru on 2016. 8. 7..
 */
public interface ISearchingApi {
    @GET("search/image?output=json&result=20")
    Call<OriginalSearchingResultModel> getQueriedImageList(@Query("apikey") String apiKey,
                                                           @Query("q") String searchImageQuery);
}