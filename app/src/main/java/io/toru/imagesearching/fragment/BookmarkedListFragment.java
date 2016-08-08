package io.toru.imagesearching.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.R;
import io.toru.imagesearching.adapter.BookmarkResultAdapter;
import io.toru.imagesearching.framework.fragment.BaseFragment;
import io.toru.imagesearching.model.SearchResultModel;

public class BookmarkedListFragment extends BaseFragment {
    private static final String TAG = BookmarkedListFragment.class.getSimpleName();

    private RecyclerView            bookmarkResultRecyclerView;
    private BookmarkResultAdapter   bookmarkResultAdapter;

    private List<SearchResultModel> bookmarkedList;

    public BookmarkedListFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG, "onCreate:");
        bookmarkedList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.w(TAG, "onViewCreated:");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_bookmark;
    }

    @Override
    public void initView(View rootView) {
        bookmarkResultRecyclerView = (RecyclerView)rootView.findViewById(R.id.myitem_recyclerview);
        bookmarkResultRecyclerView.setHasFixedSize(true);
        bookmarkResultRecyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), SPAN_COUNT));
        bookmarkResultAdapter = new BookmarkResultAdapter();
        bookmarkResultRecyclerView.setAdapter(bookmarkResultAdapter);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        Log.d("TAG", "isVisibleToUser : " + isVisibleToUser);
        if (isVisibleToUser) {
            bookmarkResultAdapter.notifyDataSetChanged();
        }
    }
}