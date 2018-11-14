package com.hzed.qmqb.admin.infrastructure.repository;

import com.hzed.qmqb.admin.persistence.auto.entity.Dict;
import com.hzed.qmqb.admin.persistence.auto.entity.example.DictExample;
import com.hzed.qmqb.admin.persistence.auto.mapper.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/14
 */
@Repository
public class DictRepository {

    @Autowired
    private DictMapper dictMapper;

    public Dict findByCode(String code) {
        DictExample example = new DictExample();
        example.createCriteria().andDicCodeEqualTo(code);
        Dict dict = dictMapper.selectOneByExample(example);
        return dict;
    }
}