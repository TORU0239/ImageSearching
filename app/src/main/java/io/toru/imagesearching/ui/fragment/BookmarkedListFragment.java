package io.toru.imagesearching.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.toru.imagesearching.R;
import io.toru.imagesearching.base.ui.fragment.BaseFragment;
import io.toru.imagesearching.ui.adapter.BookmarkResultAdapter;

public class BookmarkedListFragment extends BaseFragment {
    private static final String TAG = BookmarkedListFragment.class.getSimpleName();

    private RecyclerView            bookmarkResultRecyclerView;
    private BookmarkResultAdapter   bookmarkResultAdapter;

    private TextView emptyTextView;

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
        bookmarkResultRecyclerView.setAdapter(bookmarkResultAdapter);

        emptyTextView = (TextView)rootView.findViewById(R.id.myitem_empty_view);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("TAG", "isVisibleToUser : " + isVisibleToUser);
        if (isVisibleToUser) {
            if(bookmarkResultAdapter.getItemCount() <= 0){
                bookmarkResultRecyclerView.setVisibility(View.GONE);
                emptyTextView.setVisibility(View.VISIBLE);
            }
            else{
                bookmarkResultRecyclerView.setVisibility(View.VISIBLE);
                emptyTextView.setVisibility(View.GONE);
                bookmarkResultAdapter.notifyDataSetChanged();
            }

        }
    }
}