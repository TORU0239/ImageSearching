package io.toru.imagesearching.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.R;
import io.toru.imagesearching.ui.adapter.SearchResultAdapter;
import io.toru.imagesearching.base.ui.fragment.BaseFragment;
import io.toru.imagesearching.model.SearchResultModel;

public class SearchedListFragment extends BaseFragment {
    private static final String TAG = SearchedListFragment.class.getSimpleName();
    private RecyclerView searchResultRecyclerView;
    private SearchResultAdapter resultAdapter;

    private TextView emptyTextView;

    private List<SearchResultModel> searchResultList;

    public SearchedListFragment() {
        super();
    }

    public void updateView(List<SearchResultModel> modelList) {
        if(modelList.size() > 0){
            searchResultList.clear();
            searchResultList.addAll(modelList);
            resultAdapter.notifyDataSetChanged();
            searchResultRecyclerView.setVisibility(View.VISIBLE);
            emptyTextView.setVisibility(View.GONE);
        }
        else{
            searchResultRecyclerView.setVisibility(View.GONE);
            emptyTextView.setVisibility(View.VISIBLE);
        }
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
        emptyTextView = (TextView)rootView.findViewById(R.id.searching_empty_view);
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