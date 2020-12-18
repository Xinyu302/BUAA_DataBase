package com.yxy.market1.mapper;

import com.yxy.market1.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NoticeMapper extends JpaRepository<Notice,Integer> {
    @Modifying
    @Query("update Notice n set n.status=?2 where n.id=?1")
    @Transactional
    void updateStatusById(Integer id,String status);
}
