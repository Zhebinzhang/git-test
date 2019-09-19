package com.kylin.upms.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kylin.upms.biz.entity.Role;
import com.kylin.upms.biz.entity.User;
import com.kylin.upms.biz.entity.UserSecurity;
import com.kylin.upms.biz.mapper.UserMapper;
import com.kylin.upms.biz.service.IRoleService;
import com.kylin.upms.biz.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2019-09-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("用户名为:{}",s);
        EntityWrapper wrapper = new EntityWrapper(new User());
        wrapper.eq("username",s);
        User user = this.selectOne(wrapper);
        if (user==null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        List<Role> roleByUserName = roleService.getRoleByUserName(s);
        String[] roles = new String[roleByUserName.size()];
        int i = 0;
        for (Role role:roleByUserName){
            roles[i] = role.getName();
            i++;
        }

        UserSecurity userSecurity = new UserSecurity(s,user.getPassword(), AuthorityUtils.createAuthorityList(roles));
        return userSecurity;
    }
}
