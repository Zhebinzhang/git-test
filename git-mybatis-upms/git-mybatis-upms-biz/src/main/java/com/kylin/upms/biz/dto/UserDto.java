package com.kylin.upms.biz.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: zhebin
 * @Date: 2019/9/15 20:00
 * chain为一个布尔值，如果为true生成的set方法返回this，为false生成的set方法是void类型
 */
@Data
@Accessors(chain = true)
public class UserDto  extends  Page{
    private static final long serialVersionUID = 1L;

    /**
     * hrID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @ApiParam(value = "姓名")
    private String name;

    /**
     * 手机号码
     */
    @ApiParam(value = "手机号码")
    private String phone;

    /**
     * 住宅电话
     */
    @ApiParam(value = "住宅电话")
    private String telephone;

    /**
     * 联系地址
     */
    @ApiParam(value = "联系地址")
    private String address;

    private Integer enabled;

    /**
     * 用户名
     */
    @ApiParam(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiParam(value = "密码")
    private String password;

    private String userface;

    private String remark;
}
