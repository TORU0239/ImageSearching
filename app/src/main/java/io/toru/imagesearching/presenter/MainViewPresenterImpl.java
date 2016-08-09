package io.toru.imagesearching.presenter;

import java.util.List;

import io.toru.imagesearching.base.presenter.BaseTaskPresenter;
import io.toru.imagesearching.model.SearchResultModel;
import io.toru.imagesearching.network.ISearchResultListener;
import io.toru.imagesearching.network.NetworkRestClient;
import io.toru.imagesearching.view.MainView;

/**
 * Created by toru on 2016. 8. 9..
 */
public class MainViewPresenterImpl implements BaseTaskPresenter {

    private MainView mainView;

    public MainViewPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void query(String item) {
        NetworkRestClient.getSearchResult(item, new ISearchResultListener() {
            @Override
            public void onSearchEnd(List<SearchResultModel> searchResult) {
                mainView.onQueryResult(searchResult);
            }
        });
    }
}
