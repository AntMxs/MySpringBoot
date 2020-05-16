package com.minant.mycache.service;

import com.minant.mycache.form.DictSearchForm;
import com.minant.mycache.mapper.DictValueMapper;
import com.minant.mycache.model.DictValueInfo;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DictValueServiceImpl
 * @Description TODO DictService实现
 * @Author MinAnt
 * @Date 2020/5/15
 * @Version V1.0
 */
@Service("dictValueService")
public class DictValueServiceImpl implements DictValueService {
    private static Logger logger = LoggerFactory.getLogger(DictValueServiceImpl.class);

    @Autowired
    private DictValueMapper dictValueMapper;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Cacheable(value = "mydict", key = "#form.orderType")
    public List<DictValueInfo> queryByCode(DictSearchForm form) {
        return dictValueMapper.queryByCode(form);
    }

    /**
     * 手动获取缓存信息
     * 可自定义添加缓存
     * */
    @Override
    public void showCache() {
        // 双得检查单例模式获取
        /*CacheManager cacheManager = CacheManager.create(DictValueServiceImpl.class.getClassLoader()
                .getResourceAsStream("ehcache.xml"));*/
        // getBean方式获取
        CacheManager cacheManager = applicationContext.getBean(CacheManager.class);
        Cache cache = cacheManager.getCache("mydict");
        List<Object> keys = cache.getKeys();
        Map<Object, Element> results = cache.getAll(keys);
        Element element = cache.get("0");
    }

    @Override
    @CachePut(value = {"mydict","testdict"}, key = "#form.orderType")
    public List<DictValueInfo> queryAll(DictSearchForm form) {
        logger.info("更新缓存！！");
        return dictValueMapper.queryByCode(form);
    }

    @Override
    @Cacheable(value = "testdict", key = "#form.orderType")
    public List<DictValueInfo> queryTestAll(DictSearchForm form) {
        return dictValueMapper.queryByCode(form);
    }

    /**
     * 清除mydict所有缓存
     * beforeInvocation可以改变触发清除操作的时间，当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素
     * allEntries 。表示是否需要清除缓存中的所有元素,忽略key，清除Value的所有
     * */
    @Override
    @CacheEvict(value = "mydict", allEntries = true, beforeInvocation = true)
    public Integer clearCache() {
        logger.info("缓存mydict清除成功！！");
        return 1;
    }

    @Override
    @CacheEvict(value = "testdict", allEntries = true, beforeInvocation = true)
    public Integer clearTestCache() {
        logger.info("缓存testdict清除成功！！");
        return 1;
    }
}
