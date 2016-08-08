package io.toru.imagesearching.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.toru.imagesearching.R;
import io.toru.imagesearching.model.SearchResultModel;
import io.toru.imagesearching.viewholder.SearchResultViewHolder;

/**
 * Created by toru on 2016. 8. 8..
 */
public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultViewHolder>{
    private static final String TAG = SearchResultAdapter.class.getSimpleName();

    private List<SearchResultModel> modelList;

    public SearchResultAdapter(List<SearchResultModel> list) {
        modelList = list;
    }

    public SearchResultAdapter() {
    }

    // 새로운 뷰를 만들어 준다
    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
        SearchResultViewHolder viewholder = new SearchResultViewHolder(rootView);
        return viewholder;
    }

    // viewholder 를 이용해서 item 을 replacing.
    @Override
    public void onBindViewHolder(SearchResultViewHolder holder, final int position) {
        final SearchResultModel model = modelList.get(position);
        holder.updateView(model);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}