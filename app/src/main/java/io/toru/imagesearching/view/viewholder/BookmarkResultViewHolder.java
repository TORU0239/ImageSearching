package io.toru.imagesearching.view.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.toru.imagesearching.R;
import io.toru.imagesearching.app.ImageSearchApplication;
import io.toru.imagesearching.base.viewholder.BaseResultViewHolder;
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
                searchedImageView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(model.getLink())));
            }
        });
        Glide.with(ImageSearchApplication.getApplication()).load(model.getImage()).into(searchedImageView);
    }
}