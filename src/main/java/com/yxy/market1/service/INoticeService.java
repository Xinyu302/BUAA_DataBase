package com.yxy.market1.service;

import com.yxy.market1.entity.Notice;

import java.util.Date;
import java.util.List;

public interface INoticeService {
    void addNotice(Notice notice);

    void changeNoticeStatus(Integer noticeid,String status);

    List<Notice> getNoticeByUserId(Integer userid);

    Integer findNoticeNum(Integer userid);
}
