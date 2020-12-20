package com.yxy.market1.entity.dto.response;

public class NoticeResponse {
    private String time1;

    private String time2;

    private String content;

    private String status;

    private Integer id;

    public NoticeResponse(String time1, String time2, String content, String status,Integer id) {
        this.time1 = time1;
        this.time2 = time2;
        this.content = content;
        this.status = status;
        this.id = id;
    }

    public NoticeResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
