package com.kylin.upms.biz.service.impl;

import com.kylin.upms.biz.entity.Role;
import com.kylin.upms.biz.mapper.RoleMapper;
import com.kylin.upms.biz.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


    @Override
    public List<Role> getRoleByUserName(String userName) {
        return this.baseMapper.getRoleByUserName(userName);
    }
}
