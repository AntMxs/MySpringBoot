package com.minant.mycache.mapper;

import com.minant.mycache.form.DictSearchForm;
import com.minant.mycache.model.DictValueInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName DictValueMapper
 * @Description TODO 字典码值Mapper
 * @Author MinAnt
 * @Date 2020/5/15
 * @Version V1.0
 */
@Repository
public interface DictValueMapper {
    List<DictValueInfo> queryByCode(DictSearchForm form);
}
