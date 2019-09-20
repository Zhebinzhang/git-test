package com.kylin.upms.biz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kylin.upms.biz.dto.RoleDao;
import com.kylin.upms.biz.entity.Role;
import com.kylin.upms.biz.service.IRoleService;
import com.kylin.upms.biz.vo.ResEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api("操作角色")
@RestController
@RequestMapping("/role")
public class RoleController {

    //注入role的service接口
    @Autowired
    IRoleService iRoleService;

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResEntity rolePage(RoleDao roleDao){
        Page<Role> page=new Page<Role>(roleDao.getPageNum(),roleDao.getPageSize());

        Role role = new Role();
        BeanUtils.copyProperties(roleDao,role);

        EntityWrapper entityWrapper=new EntityWrapper(role);
        entityWrapper.like("name",role.getName());

        //传入分页的相关信息
        Page page1 = iRoleService.selectPage(page, entityWrapper);
        System.out.println(page1);
        return ResEntity.ok(page1);
    }

    /**
     *   获取所有角色的列表
     * @return
     */
    @RequestMapping(value = "getRolesList",method = RequestMethod.GET)
    public ResEntity roleList()
    {
        List<Role> roleList = iRoleService.selectList(null);
        System.out.println(roleList);
        return ResEntity.ok(roleList);
    }
    //添加角色
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResEntity add(RoleDao roleDao){
        Role role = new Role();
        BeanUtils.copyProperties(roleDao,role);
        boolean insert = iRoleService.insertOrUpdate(role);
        if (insert){
            return ResEntity.ok("添加角色成功");}
        return ResEntity.error("添加角色失败");
    }

    //获取角色判断是否存在
    @RequestMapping(method = RequestMethod.GET,value = "/getByName")
    public boolean getUser(RoleDao roleDao){
        Role role = new Role();
        BeanUtils.copyProperties(roleDao,role);
        EntityWrapper entityWrapper = new EntityWrapper(role);
        entityWrapper.like("name", role.getName());
        Role selectOne = iRoleService.selectOne(entityWrapper);
        System.out.println("role.cotroller->getByName:=====>>"+selectOne);
        if (selectOne==null){return true;}
        return false;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResEntity del(Integer id){
        boolean b = iRoleService.deleteById(id);
        if (b){ return ResEntity.ok("删除成功"); }
        return ResEntity.error("删除失败");
    }
}
