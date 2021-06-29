package com.example.stackoverflow.data.remote.response;

import java.util.List;

public class Item {
    private int accepted_answer_id;
    private int answer_count;
    private int closed_date;
    private String closed_reason;
    private String content_license;
    private int creation_date;
    private Boolean is_answered;
    private int last_activity_date;
    private int last_edit_date;
    private String link;
    private Owner owner;
    private int question_id;
    private int score;
    private List<String> tags;
    private String title;
    private int view_count;


    public Item(int accepted_answer_id, int answer_count, int closed_date, String closed_reason, String content_license, int creation_date, Boolean is_answered, int last_activity_date, int last_edit_date, String link, Owner owner, int question_id, int score, List<String> tags, String title, int view_count) {
        this.accepted_answer_id = accepted_answer_id;
        this.answer_count = answer_count;
        this.closed_date = closed_date;
        this.closed_reason = closed_reason;
        this.content_license = content_license;
        this.creation_date = creation_date;
        this.is_answered = is_answered;
        this.last_activity_date = last_activity_date;
        this.last_edit_date = last_edit_date;
        this.link = link;
        this.owner = owner;
        this.question_id = question_id;
        this.score = score;
        this.tags = tags;
        this.title = title;
        this.view_count = view_count;
    }

    public int getAccepted_answer_id() {
        return accepted_answer_id;
    }

    public void setAccepted_answer_id(int accepted_answer_id) {
        this.accepted_answer_id = accepted_answer_id;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getClosed_date() {
        return closed_date;
    }

    public void setClosed_date(int closed_date) {
        this.closed_date = closed_date;
    }

    public String getClosed_reason() {
        return closed_reason;
    }

    public void setClosed_reason(String closed_reason) {
        this.closed_reason = closed_reason;
    }

    public String getContent_license() {
        return content_license;
    }

    public void setContent_license(String content_license) {
        this.content_license = content_license;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public Boolean getIs_answered() {
        return is_answered;
    }

    public void setIs_answered(Boolean is_answered) {
        this.is_answered = is_answered;
    }

    public int getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(int last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public int getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(int last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }
}