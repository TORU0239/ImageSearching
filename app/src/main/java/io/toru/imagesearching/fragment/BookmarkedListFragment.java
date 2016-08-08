package io.toru.imagesearching.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.toru.imagesearching.R;
import io.toru.imagesearching.adapter.BookmarkResultAdapter;

public class BookmarkedListFragment extends Fragment {
    private static final String TAG = BookmarkedListFragment.class.getSimpleName();
    private RecyclerView searchResultRecyclerView;
    private BookmarkResultAdapter adapter;

    public BookmarkedListFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG, "onCreate:");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.w(TAG, "onCreateView:");
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);
        searchResultRecyclerView = (RecyclerView)view.findViewById(R.id.myitem_recyclerview);
        searchResultRecyclerView.setHasFixedSize(true);
        searchResultRecyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        adapter = new BookmarkResultAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.w(TAG, "onViewCreated:");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w(TAG, "onResume");
    }

    // test code
    public void test() {
        searchResultRecyclerView.invalidate();
        adapter.notifyDataSetChanged();
        Log.w(TAG, "size :: " + adapter.getItemCount());
    }
}