package com.heiyu.platform.device.entity.product;

import com.heiyu.platform.device.entity.common.BasicEntityPO;

public class ProductDetail extends BasicEntityPO {

    //productName 设备名称
    private String productName;
    //产品类型
    private String categoryName;
    //节点类型：0，设备；1，网关
    private byte nodeType;
    //产品状态：0，开发中；1，已上线；2，维护中；3，已废弃
    private byte productStatus;
    //产品密码
    private String productSecret;
    //数据类型：0，json；1，未开放
    private byte dataFormat;
    //网络类型：0，LoRaWan；1，以太网；2，蜂窝；3，WIFI
    private byte network;
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

    public byte getNodeType() {
        return nodeType;
    }

    public void setNodeType(byte nodeType) {
        this.nodeType = nodeType;
    }

    public byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(byte productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductSecret() {
        return productSecret;
    }

    public void setProductSecret(String productSecret) {
        this.productSecret = productSecret;
    }

    public byte getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(byte dataFormat) {
        this.dataFormat = dataFormat;
    }

    public byte getNetwork() {
        return network;
    }

    public void setNetwork(byte network) {
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
