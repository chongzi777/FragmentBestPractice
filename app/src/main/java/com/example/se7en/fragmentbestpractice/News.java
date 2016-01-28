package com.example.se7en.fragmentbestpractice;

/**
 *
 * Created by se7en on 2016/1/27.
 */
public class News {
    private String title;
    private String content;

    public News(String title,String content) {
        this.content = content;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
