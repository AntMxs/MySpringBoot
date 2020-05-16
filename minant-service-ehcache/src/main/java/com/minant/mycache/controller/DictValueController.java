package com.minant.mycache.controller;

import com.minant.mycache.form.DictSearchForm;
import com.minant.mycache.model.DictValueInfo;
import com.minant.mycache.service.DictValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @ClassName DictValueController
 * @Description TODO
 * @Author MinAnt
 * @Date 2020/5/15
 * @Version V1.0
 */
@RestController
public class DictValueController {
    private static Logger log = LoggerFactory.getLogger(DictValueController.class);
    @Autowired
    private DictValueService dictValueService;

    /**
     * 按码值查询字典信息
     * key为orderType所有当orderType一直相同时，都走的是缓存
     * */
    @RequestMapping("/queryByCode")
    public List<DictValueInfo> queryByCode(DictSearchForm form) {
        form.setDictCode("cust_type");
        form.setOrderType(1);
        log.info("第一次查询：");
        List<DictValueInfo> custls = dictValueService.queryByCode(form);
        log.info("第二次查询：");
        List<DictValueInfo> custls1 = dictValueService.queryByCode(form);
        log.info("第三次查询：");
        form.setDictCode("cert_type");
        List<DictValueInfo> certls = dictValueService.queryByCode(form);
        return certls;

    }

    /**
     * 模拟查询所有，orderType都是0
     * 同时加入mydict 和 testdict
     * */
    @RequestMapping("/queryAll")
    public List<DictValueInfo> queryAll(DictSearchForm form) {
        form.setOrderType(0);
        return dictValueService.queryAll(form);
    }

    /**
     * 查询testdict
     * */
    @RequestMapping("/queryTestAll")
    public List<DictValueInfo> queryTestAll(DictSearchForm form) {
        return dictValueService.queryTestAll(form);
    }

    /**
     * 清除mydict
     * */
    @RequestMapping("/clearCache")
    public Integer clearCache() {
        return dictValueService.clearCache();
    }

    /**
     * 清除testdict
     * */
    @RequestMapping("/clearTestCache")
    public Integer clearTestCache() {
        return dictValueService.clearTestCache();
    }

    /**
     * 手动获取缓存数据
     * 可进行自定义缓存插入操作
     * */
    @RequestMapping("/showCache")
    public void showCache() {
        dictValueService.showCache();
    }


}
