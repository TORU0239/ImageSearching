package io.toru.imagesearching.network;

import java.util.List;

import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 8..
 */
public interface ISearchResultListener {
    void onSearchEnd(List<SearchResultModel> searchResult);
}
