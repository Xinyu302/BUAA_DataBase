package com.yxy.market1.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentid;

    @Column(name = "user_id")
    private Integer userid;

    @Column(name = "productid")
    private Integer productid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(name = "content")
    private String content;

    public Comment() {
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer comment_id) {
        this.commentid = comment_id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer user_id) {
        this.userid = user_id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer product_id) {
        this.productid = product_id;
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
}
