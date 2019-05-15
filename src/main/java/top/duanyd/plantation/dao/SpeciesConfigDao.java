package top.duanyd.plantation.dao;

import top.duanyd.plantation.entity.SpeciesConfigEntity;

public interface SpeciesConfigDao {
    int deleteByPrimaryKey(Long id);

    int insert(SpeciesConfigEntity record);

    int insertSelective(SpeciesConfigEntity record);

    SpeciesConfigEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpeciesConfigEntity record);

    int updateByPrimaryKey(SpeciesConfigEntity record);
}