package io.toru.imagesearching.activity;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.adapter.MainViewPagerAdapter;
import io.toru.imagesearching.fragment.SearchedListFragment;
import io.toru.imagesearching.R;
import io.toru.imagesearching.fragment.BookmarkedListFragment;
import io.toru.imagesearching.framework.activity.BaseActivity;
import io.toru.imagesearching.framework.fragment.BaseFragment;
import io.toru.imagesearching.model.OriginalSearchingResultModel;
import io.toru.imagesearching.network.ISearchingApi;
import io.toru.imagesearching.network.NetworkRestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
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
            public void onPageSelected(int position) {
                BaseFragment fragment = fragmentList.get(position);
                fragment.selectedAction();
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        TabLayout tab = (TabLayout) findViewById(R.id.main_tab_layout);
        tab.setupWithViewPager(viewPager);
        setKakaoAppTaskDescription();
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
                performQuery(query);
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

    private void performQuery(String item) {
        Log.w(TAG, "performQuery: " + item);
        if (item.length() > 0) {
            ISearchingApi service = NetworkRestClient.getSearchingApi();
            Call<OriginalSearchingResultModel> call = service.getQueriedImageList(item);
            call.enqueue(new Callback<OriginalSearchingResultModel>() {
                @Override
                public void onResponse(Call<OriginalSearchingResultModel> call, Response<OriginalSearchingResultModel> response) {
                    OriginalSearchingResultModel result = response.body();
                    Log.w(TAG, "onResponse: message::" + response.code());
                    Log.w(TAG, "onResponse: message::" + response.message());
                    Log.d("MainActivity", "response = " + new Gson().toJson(result));

                    SearchedListFragment listFragment = (SearchedListFragment) ((MainViewPagerAdapter)viewPager.getAdapter()).getItem(0);
                    listFragment.updateView(result.getChannel().getItem());
                }

                @Override
                public void onFailure(Call<OriginalSearchingResultModel> call, Throwable t) {}
            });
        }
        else{
            Toast.makeText(MainActivity.this, "no item to search.", Toast.LENGTH_SHORT).show();
        }
    }
}