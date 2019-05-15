package top.duanyd.plantation.dao;

import top.duanyd.plantation.entity.ClimateEntity;

public interface ClimateDao {
    int deleteByPrimaryKey(Long id);

    int insert(ClimateEntity record);

    int insertSelective(ClimateEntity record);

    ClimateEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClimateEntity record);

    int updateByPrimaryKey(ClimateEntity record);
}