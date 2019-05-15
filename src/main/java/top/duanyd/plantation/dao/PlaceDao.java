package top.duanyd.plantation.dao;

import top.duanyd.plantation.entity.PlaceEntity;

public interface PlaceDao {
    int deleteByPrimaryKey(Long id);

    int insert(PlaceEntity record);

    int insertSelective(PlaceEntity record);

    PlaceEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlaceEntity record);

    int updateByPrimaryKey(PlaceEntity record);
}