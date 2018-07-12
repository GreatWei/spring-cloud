package com.example.servicemysql;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao {

    void delete(@Param("uuid") String uuid);

    UserInfo update(UserInfo user);

    UserInfo findByUuid(@Param("uuid") String uuid);

    int save(UserInfo user);
}
