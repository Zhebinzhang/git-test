package com.kylin.upms.biz.service.impl;

import com.kylin.upms.biz.entity.User;
import com.kylin.upms.biz.mapper.UserMapper;
import com.kylin.upms.biz.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2019-09-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
