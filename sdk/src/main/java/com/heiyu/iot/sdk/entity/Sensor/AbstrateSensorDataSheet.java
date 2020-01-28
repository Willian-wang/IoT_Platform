package com.heiyu.iot.sdk.entity.Sensor;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 21:04 2020/1/25
 **/

public abstract class AbstrateSensorDataSheet {
    /**数据字段名字*/
    private String dataName;
    /**数据字段ID*/
    private Long dataId;
    /**
     * 该字段的数据类型。
     * 数据类型：String Integer Double Boolean Enum
     **/
    private String dataType;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }


}
