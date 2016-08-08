package io.toru.imagesearching.view.viewholder;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.toru.imagesearching.app.ImageSearchApplication;
import io.toru.imagesearching.R;
import io.toru.imagesearching.base.viewholder.BaseResultViewHolder;
import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 8..
 */
public class SearchResultViewHolder extends BaseResultViewHolder {
    private ImageView searchedImageView;

    public SearchResultViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void updateView(final SearchResultModel model) {
        searchedImageView = (ImageView)itemView.findViewById(R.id.viewholder_imageview);
        searchedImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())  {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        // argb
                        view.getDrawable().setColorFilter(ContextCompat.getColor(v.getContext(), R.color.imageview_filter_color), PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }

                    case MotionEvent.ACTION_UP: {
                        ImageView view = (ImageView) v;
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        ImageSearchApplication.getApplication().getModelList().add(model);
                        break;
                    }
                }
                return true;
            }
        });
        Glide.with(ImageSearchApplication.getApplication()).load(model.getImage()).into(searchedImageView);
    }
}