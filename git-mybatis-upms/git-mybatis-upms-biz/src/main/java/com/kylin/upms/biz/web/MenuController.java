package com.kylin.upms.biz.web;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kylin.upms.biz.entity.Menu;
import com.kylin.upms.biz.entity.UserSecurity;
import com.kylin.upms.biz.service.IMenuService;
import com.kylin.upms.biz.vo.ResEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-09-15
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IMenuService iMenuService;

    @RequestMapping("/getMenuByUserID")
   public ResEntity getMenuByUserID(){
        logger.info(JSON.toJSONString(SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        UserSecurity user = (UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Menu> menus = iMenuService.getMenuBuUserID(user.getUsername());
       return ResEntity.ok(menus);
   }

   //获取所有的权限列表
//    @RequestMapping("/getMenusList")
//    public ResEntity menusList()
//    {
//        EntityWrapper<Menu> wrapper = new EntityWrapper<>();
//        List<Menu> menuList = iMenuService.selectList(wrapper);
//        logger.info("/menu/getMenusList-->获取的列表为",menuList);
//        return  ResEntity.ok(menuList);
//    }
    @RequestMapping("/getMenusList")
    public ResEntity get(){
        logger.info(JSON.toJSONString(SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        UserSecurity user = (UserSecurity)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Menu> menus = iMenuService.getMenuBuUserID(user.getUsername());
        return ResEntity.ok(menus);
    }
}
