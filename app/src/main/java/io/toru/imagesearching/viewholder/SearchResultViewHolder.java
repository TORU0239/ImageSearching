package io.toru.imagesearching.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.toru.imagesearching.ImageSearchApplication;
import io.toru.imagesearching.R;
import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 8..
 */
public class SearchResultViewHolder extends BaseResultViewHolder{
    private ImageView searchedImageView;
    public SearchResultViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void updateView(SearchResultModel model) {
        searchedImageView = (ImageView)itemView.findViewById(R.id.viewholder_imageview);
        Glide.with(ImageSearchApplication.getApplication()).load(model.getImage()).into(searchedImageView);
    }
}
