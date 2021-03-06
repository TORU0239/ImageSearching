package io.toru.imagesearching.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.toru.imagesearching.app.ImageSearchApplication;
import io.toru.imagesearching.R;
import io.toru.imagesearching.model.SearchResultModel;
import io.toru.imagesearching.view.viewholder.BookmarkResultViewHolder;

/**
 * Created by toru on 2016. 8. 8..
 */
public class BookmarkResultAdapter extends RecyclerView.Adapter<BookmarkResultViewHolder>{
    private static final String TAG = BookmarkResultAdapter.class.getSimpleName();

    public BookmarkResultAdapter() {}

    // 새로운 뷰를 만들어 준다
    @Override
    public BookmarkResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_viewholder, parent, false);
        return new BookmarkResultViewHolder(rootView);
    }

    // viewholder 를 이용해서 item 을 replacing.
    @Override
    public void onBindViewHolder(BookmarkResultViewHolder holder, final int position) {
        final SearchResultModel model = ImageSearchApplication.getApplication().getModelList().get(position);
        holder.updateView(model);
    }

    @Override
    public int getItemCount() {
        return ImageSearchApplication.getApplication().getModelList().size();
    }
}