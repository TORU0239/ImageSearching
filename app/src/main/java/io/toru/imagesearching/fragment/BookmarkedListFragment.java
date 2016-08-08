package io.toru.imagesearching.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import io.toru.imagesearching.R;
import io.toru.imagesearching.adapter.BookmarkResultAdapter;
import io.toru.imagesearching.framework.fragment.BaseFragment;

public class BookmarkedListFragment extends BaseFragment {
    private static final String TAG = BookmarkedListFragment.class.getSimpleName();

    private RecyclerView            bookmarkResultRecyclerView;
    private BookmarkResultAdapter   bookmarkResultAdapter;

    public BookmarkedListFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG, "onCreate:");
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
    }

    @Override
    public void selectedAction() {
        bookmarkResultRecyclerView.invalidate();
        bookmarkResultAdapter.notifyDataSetChanged();
        Log.w(TAG, "size :: " + bookmarkResultAdapter.getItemCount());
    }
}