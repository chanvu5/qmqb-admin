package com.hzed.qmqb.admin.persistence.auto.mapper;

import com.hzed.qmqb.admin.persistence.auto.entity.Dict;
import com.hzed.qmqb.admin.persistence.auto.entity.example.DictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    List<Dict> selectByExampleSelective(@Param("example") DictExample example, @Param("selective") Dict.Column ... selective);

    Dict selectByPrimaryKey(Long id);

    Dict selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") Dict.Column ... selective);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    Dict selectOneByExample(DictExample example);

    Dict selectOneByExampleSelective(@Param("example") DictExample example, @Param("selective") Dict.Column ... selective);

    int batchInsert(@Param("list") List<Dict> list);

    int batchInsertSelective(@Param("list") List<Dict> list, @Param("selective") Dict.Column ... selective);
}