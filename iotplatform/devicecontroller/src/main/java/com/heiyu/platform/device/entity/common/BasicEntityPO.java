package com.heiyu.platform.device.entity.common;

import java.sql.Timestamp;

/**
 * @ClassName: BasicEntity
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 11:40 2019/8/6
 * @Version: 1.0
 **/

public class BasicEntityPO {

    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtUpdate;
    private Boolean remove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }
}
