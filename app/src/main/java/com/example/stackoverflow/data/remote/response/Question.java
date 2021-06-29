package com.example.stackoverflow.data.remote.response;

import java.util.List;

public class Question {

    private boolean has_more;
    private List<Item> items;
    private int quota_max;
    private int quota_remaining;

    public Question(boolean has_more, List<Item> items, int quota_max, int quota_remaining) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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
