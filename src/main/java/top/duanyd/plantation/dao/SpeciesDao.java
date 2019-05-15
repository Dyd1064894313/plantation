package top.duanyd.plantation.dao;

import top.duanyd.plantation.entity.SpeciesEntity;

public interface SpeciesDao {
    int deleteByPrimaryKey(Long id);

    int insert(SpeciesEntity record);

    int insertSelective(SpeciesEntity record);

    SpeciesEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpeciesEntity record);

    int updateByPrimaryKey(SpeciesEntity record);
}