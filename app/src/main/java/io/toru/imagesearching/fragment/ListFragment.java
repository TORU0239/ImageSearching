package io.toru.imagesearching.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.xml.sax.SAXNotRecognizedException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.R;
import io.toru.imagesearching.model.SearchResultModel;

public class ListFragment extends Fragment {

    private static final String TAG = ListFragment.class.getSimpleName();
    private static final int SPAN_COUNT = 2;

    private RecyclerView searchResultRecyclerView;

    public ListFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.w(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.w(TAG, "onCreateView");

        View rootView = inflater.inflate(R.layout.fragment_tab_1, container, false);
        searchResultRecyclerView = (RecyclerView) rootView.findViewById(R.id.searching_recyclerview);
        searchResultRecyclerView.setHasFixedSize(true);
        searchResultRecyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), SPAN_COUNT));

        return rootView;
    }

    private ArrayList<SearchResultModel> testImage() {
        // test code before a
        ArrayList<SearchResultModel> searchedModelList = new ArrayList<>();

        SearchResultModel model1=  new SearchResultModel();
        model1.setImage("http://dthumb.phinf.naver.net/?src=%22http%3A%2F%2Fimage.fnnews.com%2Fresource%2Fmedia%2Fimage%2F2016%2F04%2F07%2F201604071700205185_m.png%22&type=f220");

        SearchResultModel model2=  new SearchResultModel();
        model2.setImage("http://cfile234.uf.daum.net/image/27033A3E57848C241F42B6");

        SearchResultModel model3=  new SearchResultModel();
        model3.setImage("http://cfile8.uf.tistory.com/image/1524CF3F50C857B002EF74");

        SearchResultModel model4=  new SearchResultModel();
        model4.setImage("http://cfile22.uf.tistory.com/image/251DDC39548EE62B303156");


        searchedModelList.add(model1);
        searchedModelList.add(model2);
        searchedModelList.add(model3);
        searchedModelList.add(model4);
        searchedModelList.add(model2);
        searchedModelList.add(model3);
        searchedModelList.add(model1);
        searchedModelList.add(model4);
        searchedModelList.add(model3);
        searchedModelList.add(model1);
        searchedModelList.add(model4);
        searchedModelList.add(model3);
        searchedModelList.add(model2);
        searchedModelList.add(model1);
        searchedModelList.add(model3);
        searchedModelList.add(model4);
        searchedModelList.add(model2);
        searchedModelList.add(model3);

        return searchedModelList;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w(TAG, "onViewCreated");
        searchResultRecyclerView.setAdapter(new SearchResultAdapter(testImage()));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    class SearchResultAdapter extends RecyclerView.Adapter<SearchResultViewHolder>{
        private List<SearchResultModel> modelList;

        public SearchResultAdapter(List<SearchResultModel> list) {
            modelList = list;
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
        public void onBindViewHolder(SearchResultViewHolder holder, int position) {
            SearchResultModel model = modelList.get(position);
            Glide.with(ListFragment.this).load(model.getImage()).into(holder.searchedImageView);
        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }
    }

    class SearchResultViewHolder extends RecyclerView.ViewHolder{
        private ImageView searchedImageView;
        public SearchResultViewHolder(View itemView) {
            super(itemView);
            searchedImageView = (ImageView)itemView.findViewById(R.id.viewholder_imageview);
        }
    }
}