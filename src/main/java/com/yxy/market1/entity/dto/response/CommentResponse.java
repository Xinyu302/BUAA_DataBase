package com.yxy.market1.entity.dto.response;

import java.util.Date;

public class CommentResponse {
    private String username;

    private Date date;

    private String content;

    public CommentResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
