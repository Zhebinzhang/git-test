package com.kylin.upms.biz.dto;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @Author: zhebin
 * @Date: 2019/9/15 19:59
 */
@Data
public class Page {
    @ApiParam(value = "当前页",required = true)
    private int pageNum;
    @ApiParam(value = "每页显示的条数",required = true)
    private int pageSize;
}
