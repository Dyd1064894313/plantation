package top.duanyd.plantation.dao;

import top.duanyd.plantation.entity.CharacterDefEntity;

public interface CharacterDefDao {
    int deleteByPrimaryKey(Long id);

    int insert(CharacterDefEntity record);

    int insertSelective(CharacterDefEntity record);

    CharacterDefEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CharacterDefEntity record);

    int updateByPrimaryKey(CharacterDefEntity record);
}