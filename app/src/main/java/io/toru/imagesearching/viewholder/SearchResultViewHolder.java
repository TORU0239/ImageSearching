package io.toru.imagesearching.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.toru.imagesearching.app.ImageSearchApplication;
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
    public void updateView(final SearchResultModel model) {
        searchedImageView = (ImageView)itemView.findViewById(R.id.viewholder_imageview);
        searchedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageSearchApplication.getApplication().getModelList().add(model);
                // TODO : 추가될 때매다 뷰에 알려 주는 부분을 추가해야 함
                // TODO : 아니면 탭이 바뀔 때, 내 보관함에서 보관함을 갱신해 주어야 함
            }
        });
        Glide.with(ImageSearchApplication.getApplication()).load(model.getImage()).into(searchedImageView);
    }
}