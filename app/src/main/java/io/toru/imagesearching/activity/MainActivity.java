package io.toru.imagesearching.activity;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.Utility.Util;
import io.toru.imagesearching.fragment.ListFragment;
import io.toru.imagesearching.R;
import io.toru.imagesearching.fragment.WidgetFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setTitle("KakaoTalk");
        setSupportActionBar(toolbar);

        final ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ListFragment());
        fragmentList.add(new WidgetFragment());

        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                Fragment fragment = fragmentList.get(position);

                if(fragment instanceof ListFragment){
                    ((ListFragment) fragment).doSelectedAction();
                }
                else if(fragment instanceof WidgetFragment){
                    ((WidgetFragment) fragment).test();
                }
                else{}
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        TabLayout tab = (TabLayout) findViewById(R.id.main_tab_layout);
        tab.setupWithViewPager(viewPager);

        setTaskDescription();
    }

    @TargetApi(23)
    private void setTaskDescription() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(getString(R.string.app_name).toString(), bm, getResources().getColor(R.color.kakaoMain, null));
            setTaskDescription(taskDescription);
        }
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

    private void performQuery(String item) {
        Log.w(TAG, "performQuery: " + item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> fragmentList;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "List";
                case 1:
                    return "Widgets";
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public Fragment getItem(int position) {
            Log.w(TAG, "getItem: position :: " + position);
            return fragmentList.get(position);
        }
    }
}