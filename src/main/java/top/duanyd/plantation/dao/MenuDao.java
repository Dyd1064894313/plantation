package top.duanyd.plantation.dao;

import top.duanyd.plantation.entity.MenuEntity;

import java.util.List;

public interface MenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(MenuEntity record);

    int insertSelective(MenuEntity record);

    MenuEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuEntity record);

    int updateByPrimaryKey(MenuEntity record);

    List<MenuEntity> selectAllMenus();
}