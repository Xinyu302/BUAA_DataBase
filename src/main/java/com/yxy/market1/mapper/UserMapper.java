package com.yxy.market1.mapper;

import com.yxy.market1.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    @Select("select * from usertable order by user_id desc")
    List<User> getUserList();

    @
}
