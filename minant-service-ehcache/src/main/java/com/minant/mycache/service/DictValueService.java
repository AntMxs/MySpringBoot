package com.minant.mycache.service;

import com.minant.mycache.form.DictSearchForm;
import com.minant.mycache.model.DictValueInfo;

import java.util.List;

/**
 * @ClassName DictValueService
 * @Description TODO 字典码值Mapper
 * @Author MinAnt
 * @Date 2020/5/15
 * @Version V1.0
 */
public interface DictValueService {
    List<DictValueInfo> queryByCode(DictSearchForm form);
    List<DictValueInfo> queryAll(DictSearchForm form);
    List<DictValueInfo> queryTestAll(DictSearchForm form);
    Integer clearCache();
    Integer clearTestCache();
    void showCache();
}
