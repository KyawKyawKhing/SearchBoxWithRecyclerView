package com.kkk.umg.searchboxwithrecyclerview.model;

/**
 * Created by Dell on 2/21/2018.
 */

public class BlogData {
    private String blog_title;
    private String blog_desp;

    public BlogData(String title, String desp) {
        this.blog_title = title;
        this.blog_desp = desp;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public String getBlog_desp() {
        return blog_desp;
    }

}
