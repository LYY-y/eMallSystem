package com.eMall.entity.enums;

import com.eMall.entity.enums.BaseIndexEnum;

public enum State implements BaseIndexEnum {
//    SALING("上架",0), OFF("下架",1), DELETE("删除",2),
//    REVIEWING("审核中",3);
    SALING(0), OFF(1), DELETE(2), REVIEWING(3);

    private int index;

    State(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
