package io.toru.imagesearching.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.toru.imagesearching.R;
import io.toru.imagesearching.app.ImageSearchApplication;
import io.toru.imagesearching.framework.viewholder.BaseResultViewHolder;
import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 8..
 */
public class BookmarkResultViewHolder extends BaseResultViewHolder {
    private ImageView searchedImageView;

    public BookmarkResultViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void updateView(final SearchResultModel model) {
        searchedImageView = (ImageView)itemView.findViewById(R.id.viewholder_imageview);
        searchedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageSearchApplication.getApplication().getModelList().add(model);
            }
        });
        Glide.with(ImageSearchApplication.getApplication()).load(model.getImage()).into(searchedImageView);
    }
}