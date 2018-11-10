package com.hzed.qmqb.admin.persistence.auto.mapper;

import com.hzed.qmqb.admin.persistence.auto.entity.User;
import com.hzed.qmqb.admin.persistence.auto.entity.example.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    List<User> selectByExampleSelective(@Param("example") UserExample example, @Param("selective") User.Column ... selective);

    User selectByPrimaryKey(Long id);

    User selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") User.Column ... selective);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectOneByExample(UserExample example);

    User selectOneByExampleSelective(@Param("example") UserExample example, @Param("selective") User.Column ... selective);

    int batchInsert(@Param("list") List<User> list);

    int batchInsertSelective(@Param("list") List<User> list, @Param("selective") User.Column ... selective);
}