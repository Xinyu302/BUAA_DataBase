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
    private Integer userid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    public Notice() {

    }

    public Notice(Integer userid, Date time, String content) {
        this.userid = userid;
        this.time = time;
        this.content = content;
        this.status = "未读";
    }

    public Notice(Integer userid, Date time, String content, String status) {
        this.userid = userid;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer user_id) {
        this.userid = user_id;
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
