package top.duanyd.plantation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.duanyd.plantation.dao.MenuDao;
import top.duanyd.plantation.entity.MenuEntity;

import java.util.List;

@Service
public class MenuService {
    private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private MenuDao menuDao;
    public List<MenuEntity> getAllMenus(){
        return menuDao.selectAllMenus();
    }
}
