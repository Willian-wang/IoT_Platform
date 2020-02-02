package com.heiyu.platform.device.entity.common;

import com.heiyu.platform.device.common.IdGenerator;

import java.sql.Timestamp;

/**
 * 基础PO类，所有PO类都会有ID,创建时间，更新时间，删除标记四个数据
 * @author WangYi
 * @date 11:40 2019/8/6
 * @version 1.0
 **/

public class BasicEntityPO {

    private Long id;
    private Timestamp gmtCreateTime;
    private Timestamp gmtUpdateTime;
    private Boolean remove;

    public void setBasicInf(){
        id = IdGenerator.getId();
        gmtCreateTime =new Timestamp(System.currentTimeMillis());
        gmtUpdateTime = new Timestamp(System.currentTimeMillis());
        remove = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Timestamp gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Timestamp getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    public void setGmtUpdateTime(Timestamp gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }
}
