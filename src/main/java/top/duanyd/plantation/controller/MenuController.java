package top.duanyd.plantation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.duanyd.plantation.dto.Result;
import top.duanyd.plantation.entity.MenuEntity;
import top.duanyd.plantation.service.MenuService;
import top.duanyd.plantation.utils.ResultUtil;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping("/getAllMenus")
    @ResponseBody
    public Result<List<MenuEntity>> getMenus(){
        logger.info("进入getMenus方法");
        List<MenuEntity> allMenus = menuService.getAllMenus();
        return ResultUtil.success(allMenus);
    }
}
