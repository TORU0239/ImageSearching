package io.toru.imagesearching.framework.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 8..
 */
public abstract class BaseResultViewHolder extends RecyclerView.ViewHolder {
    public BaseResultViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void updateView(final SearchResultModel model);
}
