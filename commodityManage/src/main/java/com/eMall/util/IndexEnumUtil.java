package com.eMall.util;

import com.eMall.entity.enums.BaseIndexEnum;

//将数值转换为枚举实例
public class IndexEnumUtil {
    public static <E extends Enum<?> & BaseIndexEnum> E indexof(Class<E> enumClass, int index){
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants){
            if (e.getIndex() == index){
                return e;
            }
        }
        return null;
    }
}
