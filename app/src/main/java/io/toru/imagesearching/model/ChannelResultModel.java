package io.toru.imagesearching.model;

/**
 * Created by toru on 2016. 8. 7..
 */

import java.util.ArrayList;
import java.util.List;

public class ChannelResultModel {
    private int result;
    private int pageCount;
    private String title;
    private int totalCount;
    private String description;
    private List<SearchResultModel> item = new ArrayList<>();
    private String lastBuildDate;
    private String link;
    private String generator;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SearchResultModel> getItem() {
        return item;
    }

    public void setItem(List<SearchResultModel> item) {
        this.item = item;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }
}
