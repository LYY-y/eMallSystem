package com.eMall.dto;

import com.eMall.entity.Commodity;
import com.eMall.entity.enums.State;

/**
 * 封装编辑商品信息后返回的结果
 */
public class EditCommodityInfoExecution {
    private CommodityBaseInfo commodityBaseInfo;
    //商品状态：0->上架; 1->下架; 2->删除； 3->审核中
    private int state;
    private String stateInfo;

    //编辑成功的构造器
    public EditCommodityInfoExecution(CommodityBaseInfo commodityBaseInfo, State state) {
        this.commodityBaseInfo = commodityBaseInfo;
        this.state = state.getIndex();
        this.stateInfo = state.toString();
    }

    //编辑失败的构造器
    public EditCommodityInfoExecution(State state) {
        this.state = state.getIndex();
        this.stateInfo = state.toString();
    }

    public CommodityBaseInfo getCommodityBaseInfo() {
        return commodityBaseInfo;
    }

    public void setCommodity(CommodityBaseInfo commodityBaseInfo) {
        this.commodityBaseInfo = commodityBaseInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "EditCommodityInfoExecution{" +
                "commodityBaseInfo=" + commodityBaseInfo +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
