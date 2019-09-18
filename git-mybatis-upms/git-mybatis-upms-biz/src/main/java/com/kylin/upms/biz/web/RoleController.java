package com.kylin.upms.biz.web;


import com.kylin.upms.biz.vo.ResEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-09-15
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResEntity rolePage(){
        return ResEntity.ok();
    }
}
