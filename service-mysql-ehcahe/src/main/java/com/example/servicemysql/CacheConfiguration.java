package com.example.servicemysql;

import org.springframework.cache.annotation.EnableCaching;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfiguration {
    /**
     * ehcache 主要的管理器
     *
     * @param bean
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
        System.out.println("CacheConfiguration.ehCacheCacheManager");
        return new EhCacheCacheManager(bean.getObject());
    }

    /**
     * 据share与否的设置
     * spring分别通过CacheManager.create()
     * 或new CacheManager()方式来创建一个
     * <p>
     * 也就是说可以通过过这个俩设置cached的基地是这距离的spring杜勇，还是跟别的（如hibernate的Ehcache共享）
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        System.out.println("CacheConfiguration.ehCacheManagerFactoryBean");
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }
}
