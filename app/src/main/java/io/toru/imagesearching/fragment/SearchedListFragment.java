package io.toru.imagesearching.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.R;
import io.toru.imagesearching.adapter.SearchResultAdapter;
import io.toru.imagesearching.framework.fragment.BaseFragment;
import io.toru.imagesearching.model.SearchResultModel;

public class SearchedListFragment extends BaseFragment {
    private static final String TAG = SearchedListFragment.class.getSimpleName();
    private RecyclerView searchResultRecyclerView;
    private SearchResultAdapter resultAdapter;

    private List<SearchResultModel> searchResultList;

    public SearchedListFragment() {
        super();
    }

    public void updateView(List<SearchResultModel> modelList) {
        searchResultList.clear();
        searchResultList.addAll(modelList);
        resultAdapter.notifyDataSetChanged();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView(View rootView) {
        searchResultRecyclerView = (RecyclerView) rootView.findViewById(R.id.searching_recycleview);
        searchResultRecyclerView.setHasFixedSize(true);
        searchResultRecyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), SPAN_COUNT));
        resultAdapter = new SearchResultAdapter(searchResultList);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.w(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        searchResultList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w(TAG, "onViewCreated");
        searchResultRecyclerView.setAdapter(resultAdapter);
    }
}