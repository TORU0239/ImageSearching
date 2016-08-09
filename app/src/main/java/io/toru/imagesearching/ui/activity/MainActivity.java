package io.toru.imagesearching.ui.activity;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.base.presenter.BaseTaskPresenter;
import io.toru.imagesearching.presenter.MainViewPresenterImpl;
import io.toru.imagesearching.ui.adapter.MainViewPagerAdapter;
import io.toru.imagesearching.ui.fragment.SearchedListFragment;
import io.toru.imagesearching.R;
import io.toru.imagesearching.ui.fragment.BookmarkedListFragment;
import io.toru.imagesearching.base.ui.activity.BaseActivity;
import io.toru.imagesearching.base.ui.fragment.BaseFragment;
import io.toru.imagesearching.model.SearchResultModel;
import io.toru.imagesearching.network.ISearchResultListener;
import io.toru.imagesearching.network.NetworkRestClient;
import io.toru.imagesearching.view.MainView;

public class MainActivity extends BaseActivity implements MainView{
    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager viewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        final ArrayList<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new SearchedListFragment());
        fragmentList.add(new BookmarkedListFragment());

        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        TabLayout tab = (TabLayout) findViewById(R.id.main_tab_layout);
        tab.setupWithViewPager(viewPager);
        setKakaoAppTaskDescription();

        setTaskPresenter(new MainViewPresenterImpl(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView)searchMenuItem.getActionView();
        searchView.setQueryHint(getString(R.string.search));
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ((MainViewPresenterImpl)getTaskPresenter()).query(query);
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.w(TAG, "onQueryTextSubmit: newText :" + newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(21)
    private void setKakaoAppTaskDescription() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(getString(R.string.app_name), bm, ContextCompat.getColor(MainActivity.this, R.color.kakaoMain));
            setTaskDescription(taskDescription);
        }
    }

    @Override
    public void onQueryResult(List<SearchResultModel> searchResult) {
        SearchedListFragment listFragment = (SearchedListFragment) ((MainViewPagerAdapter)viewPager.getAdapter()).getItem(0);
        listFragment.onNotifyDataSetChanged(searchResult);
    }
}