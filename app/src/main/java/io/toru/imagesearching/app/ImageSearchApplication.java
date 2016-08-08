package io.toru.imagesearching.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import io.toru.imagesearching.model.SearchResultModel;

/**
 * Created by toru on 2016. 8. 5..
 */
public class ImageSearchApplication extends Application {
    private static ImageSearchApplication application;

    private List<SearchResultModel> modelList;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        modelList = new ArrayList<>();
    }

    public static ImageSearchApplication getApplication() {
        return application;
    }

    public List<SearchResultModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<SearchResultModel> modelList) {
        this.modelList = modelList;
    }

    public void addModelList(SearchResultModel model){
        if(modelList.contains(model)){
            modelList.remove(model);
        }
        modelList.add(model);
    }
}