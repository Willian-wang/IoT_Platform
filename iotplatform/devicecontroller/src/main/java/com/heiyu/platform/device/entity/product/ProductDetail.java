package com.heiyu.platform.device.entity.product;

import com.heiyu.platform.device.entity.common.BasicEntityPO;

public class ProductDetail extends BasicEntityPO {

    //productName 设备名称
    private String productName;
    //产品类型
    private String categoryName;
    //节点类型：0，设备；1，网关
    private Byte nodeType;
    //产品状态：0，开发中；1，已上线；2，维护中；3，已废弃
    private Byte productStatus;
    //产品密码
    private String productSecret;
    //数据类型：0，json；1，未开放
    private Byte dataFormat;
    //网络类型：0，LoRaWan；1，以太网；2，蜂窝；3，WIFI
    private Byte network;
    //产品钥匙
    private String productKey;
    //是否动态注册
    private boolean autoRegister;
    //所属的用户ID
    private Long userId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Byte getNodeType() {
        return nodeType;
    }

    public void setNodeType(Byte nodeType) {
        this.nodeType = nodeType;
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductSecret() {
        return productSecret;
    }

    public void setProductSecret(String productSecret) {
        this.productSecret = productSecret;
    }

    public Byte getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(Byte dataFormat) {
        this.dataFormat = dataFormat;
    }

    public Byte getNetwork() {
        return network;
    }

    public void setNetwork(Byte network) {
        this.network = network;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public boolean isAutoRegister() {
        return autoRegister;
    }

    public void setAutoRegister(boolean autoRegister) {
        this.autoRegister = autoRegister;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
