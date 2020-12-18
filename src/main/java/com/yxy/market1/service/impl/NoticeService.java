package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Notice;
import com.yxy.market1.mapper.NoticeMapper;
import com.yxy.market1.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService implements INoticeService {
    @Autowired
    private NoticeMapper nMapper;

    @Override
    public void addNotice(Notice notice) {
        nMapper.save(notice);
    }

    @Override
    public void changeNoticeStatus(Integer noticeid,String status) {
        nMapper.updateStatusById(noticeid,status);
    }
}
