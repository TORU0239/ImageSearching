package io.toru.imagesearching.presenter;

import java.util.List;

import io.toru.imagesearching.base.presenter.BaseTaskPresenter;
import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 9..
 */
public interface SearchResultPresenter extends BaseTaskPresenter {
    void onNotifyFragment(List<SearchResultModel> modelList);
}