package io.toru.imagesearching.view;

import java.util.List;

import io.toru.imagesearching.base.view.BaseView;
import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 9..
 */
public interface MainView extends BaseView {
    void onQueryResult(List<SearchResultModel> modelList);
}
