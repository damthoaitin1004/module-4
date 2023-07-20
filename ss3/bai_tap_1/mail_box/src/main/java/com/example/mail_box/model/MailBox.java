package com.example.mail_box.model;

public class MailBox {
    private int id;
    private String languages;
    private int pageSize;
    private boolean spamFilter;
    private String sigNature;
    public MailBox(){

    }

    public MailBox(String languages, int pageSize, boolean spamFilter, String sigNature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.sigNature = sigNature;
    }

    public MailBox(int id, String languages, int pageSize, boolean spamFilter, String sigNature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.sigNature = sigNature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSigNature() {
        return sigNature;
    }

    public void setSigNature(String sigNature) {
        this.sigNature = sigNature;
    }

}
