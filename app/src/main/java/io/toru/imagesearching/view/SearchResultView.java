package io.toru.imagesearching.view;

import java.util.List;

import io.toru.imagesearching.base.view.BaseView;
import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 9..
 */
public interface SearchResultView extends BaseView {
    // 뷰에서 하는 일은 viewpager adapter 를 갱신해 주는 것이다
    void onNotifyDataSetChanged(List<SearchResultModel> result);
}