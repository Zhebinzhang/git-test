package com.kylin.upms.biz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kylin.upms.biz.dto.UserDto;
import com.kylin.upms.biz.entity.User;
import com.kylin.upms.biz.service.IUserService;
import com.kylin.upms.biz.vo.RestEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api("操作用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @ApiOperation("根据查询条件分页查询用户列表")
    @RequestMapping(method = RequestMethod.GET)
    public RestEntity get(UserDto userDto){
        Page<User> page = new Page<User>(userDto.getPageNum(),userDto.getPageSize());

        User user  = new User();

        BeanUtils.copyProperties(userDto,user);

        EntityWrapper entityWrapper = new EntityWrapper(user);

        entityWrapper.like("username",user.getUsername());

        Page page1 = iUserService.selectPage(page, entityWrapper);

        System.out.println(page1.getRecords());

        return RestEntity.ok(page1);
    }
}
