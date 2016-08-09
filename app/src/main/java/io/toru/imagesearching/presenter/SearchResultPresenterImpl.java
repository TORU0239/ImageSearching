package io.toru.imagesearching.presenter;

import java.util.List;

import io.toru.imagesearching.model.SearchResultModel;
import io.toru.imagesearching.view.SearchResultView;

/**
 * Created by toru on 2016. 8. 9..
 */
public class SearchResultPresenterImpl implements SearchResultPresenter {

    private SearchResultView searchResultView;

    public SearchResultPresenterImpl(SearchResultView searchResultView) {
        this.searchResultView = searchResultView;
    }

    @Override
    public void query(String query) {}

    @Override
    public void onNotifyFragment(List<SearchResultModel> modelList) {
        searchResultView.onNotifyDataSetChanged(modelList);
    }
}
