package com.example.servicemysql;

import org.apache.ibatis.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'user'";
    private static final String DEMO_CACHE_NAME = "users";

    @Autowired
    private UserInfoDao userInfoDao;

    //删除用户数据
    @CacheEvict(value = DEMO_CACHE_NAME, key = "'user_'+#uuid")//这是清除缓存
    public void delete(String uuid) {
        userInfoDao.delete(uuid);
    }

    //更新用户数据
    @CachePut(value = DEMO_CACHE_NAME, key = "'user_'+#user.getUuid()")
    public UserInfo update(UserInfo user) throws CacheException {
        UserInfo user1 = userInfoDao.findByUuid(user.getUuid());
        if (null == user1) {
            throw new CacheException("Not Find");
        }
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        return user1;
    }

    //查找用户数据
    @Cacheable(value = DEMO_CACHE_NAME, key = "'user_'+#uuid")
    public UserInfo findByUuid(String uuid) {
        //若找不到缓存将打印出提示语句
        System.err.println("没有走缓存！" + uuid);
        return userInfoDao.findByUuid(uuid);
    }

    //保存用户数据
    @CacheEvict(value = DEMO_CACHE_NAME, key = CACHE_KEY)
    public int save(UserInfo user) {
        return userInfoDao.save(user);
    }
}
