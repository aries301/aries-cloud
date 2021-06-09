package com.aries.cloud.common.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {
    @TableId(type = IdType.NONE)
    private String id;
    @TableLogic
    private Integer deleted;
    private String crtId;
    private Date crtTime;
    private String crtIp;
    private String updId;
    private Date updTime;
    private String updIp;
}
