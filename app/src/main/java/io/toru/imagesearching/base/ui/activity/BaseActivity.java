package io.toru.imagesearching.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.toru.imagesearching.R;
import io.toru.imagesearching.base.presenter.BaseTaskPresenter;
import io.toru.imagesearching.base.view.BaseView;

/**
 * Created by toru on 2016. 8. 8..
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    private BaseTaskPresenter taskPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
        initView();
    }

    public abstract int getLayoutId();
    public abstract void initView();
    public abstract BaseTaskPresenter getTaskPresenter();

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onItemClick() {}
}