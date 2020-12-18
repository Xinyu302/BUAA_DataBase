package com.yxy.market1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    public Notice() {

    }

    public Notice(Integer user_id, Date time, String content) {
        this.user_id = user_id;
        this.time = time;
        this.content = content;
        this.status = "未读";
    }

    public Notice(Integer user_id, Date time, String content, String status) {
        this.user_id = user_id;
        this.time = time;
        this.content = content;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
