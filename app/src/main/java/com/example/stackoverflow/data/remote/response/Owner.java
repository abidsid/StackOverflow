package com.example.stackoverflow.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("accept_rate")
    private int accept_rate;
    @SerializedName("account_id")
    private int account_id;
    @SerializedName("display_name")
    private String display_name;
    @SerializedName("link")
    private String link;
    @SerializedName("profile_image")
    private String profile_image;
    @SerializedName("reputation")
    private int reputation;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("user_type")
    private String user_type;


    public Owner(int accept_rate, int account_id, String display_name, String link, String profile_image, int reputation, int user_id, String user_type) {
        this.accept_rate = accept_rate;
        this.account_id = account_id;
        this.display_name = display_name;
        this.link = link;
        this.profile_image = profile_image;
        this.reputation = reputation;
        this.user_id = user_id;
        this.user_type = user_type;
    }

    public int getAccept_rate() {
        return accept_rate;
    }

    public void setAccept_rate(int accept_rate) {
        this.accept_rate = accept_rate;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}