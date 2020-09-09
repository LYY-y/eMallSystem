package com.eMall.entity.enums;

import com.eMall.entity.enums.BaseIndexEnum;

public enum Promotion implements BaseIndexEnum {

//    NONE("无",0), EMALL("官方活动", 1), ENOUGH("满减优惠",2),
//    TIMELIMIT("限时活动",3);

    NONE(0), EMALL(1), ENOUGH(2), TIMELIMIT(3);

    private int index;

    Promotion(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
