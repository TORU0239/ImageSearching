package io.toru.imagesearching.base.presenter;

import io.toru.imagesearching.base.view.BaseView;

/**
 * Created by toru on 2016. 8. 9..
 */
public interface BaseTaskPresenter {
    // 기본적인 로직을 정의함
    void query(String query);
}