package com.example.stackoverflow.data.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionList {

    @SerializedName("has_more")
    private boolean has_more;
    @SerializedName("items")
    private List<Question> items;
    @SerializedName("quota_max")
    private int quota_max;
    @SerializedName("quota_remaining")
    private int quota_remaining;

    public QuestionList(boolean has_more, List<Question> items, int quota_max, int quota_remaining) {
        this.has_more = has_more;
        this.items = items;
        this.quota_max = quota_max;
        this.quota_remaining = quota_remaining;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public List<Question> getItems() {
        return items;
    }

    public void setItems(List<Question> items) {
        this.items = items;
    }

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }
}
