package io.toru.imagesearching.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.ImageSearchApplication;
import io.toru.imagesearching.R;
import io.toru.imagesearching.framework.fragment.BaseFragment;
import io.toru.imagesearching.model.SearchResultModel;

public class ListFragment extends BaseFragment {

    private static final String TAG = ListFragment.class.getSimpleName();
    private static final int SPAN_COUNT = 2;

    private RecyclerView searchResultRecyclerView;

    public ListFragment() {
        super();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tab_1;
    }

    @Override
    public void initView(View rootView) {
        searchResultRecyclerView = (RecyclerView) rootView.findViewById(R.id.searching_recycleview);
        searchResultRecyclerView.setHasFixedSize(true);
        searchResultRecyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), SPAN_COUNT));
    }

    @Override
    public void selectedAction() {
        Log.w(TAG, "test: test, ListFragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.w(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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
        public void onBindViewHolder(SearchResultViewHolder holder, final int position) {
            final SearchResultModel model = modelList.get(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "position :: " + position, Toast.LENGTH_SHORT).show();
                    ImageSearchApplication.getApplication().getModelList().add(model);

                    // TODO : 추가될 때매다 뷰에 알려 주는 부분을 추가해야 함
                    // TODO : 아니면 탭이 바뀔 때, 내 보관함에서 보관함을 갱신해 주어야 함
                }
            });
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