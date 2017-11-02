package com.example.ceshi.ceshi01.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.ceshi.ceshi01.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    public User getUserById(@Param("id") Integer id);

}
