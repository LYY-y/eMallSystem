package com.eMall.util;

import com.eMall.entity.enums.BaseIndexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndexEnumTypeHandler <E extends Enum<?> & BaseIndexEnum> extends BaseTypeHandler<BaseIndexEnum> {
    private Class<E> type;

    public IndexEnumTypeHandler(Class<E> type) {
        if (type == null){
            throw new IllegalArgumentException("Type Argument cannot be null");
        }
        this.type = type;
    }

    //用于设置参数时，如何把java类型的参数转换为数据库类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseIndexEnum baseIndexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,baseIndexEnum.getIndex());
    }

    //通过字段名称获取字段，如何把数据库类型转换成java类型
    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int index = resultSet.getInt(columnName);
        return resultSet.wasNull()?null:indexOf(index);
    }

    //通过字段索引获取字段，如何把数据库类型转换成java类型
    @Override
    public E getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int index = resultSet.getInt(columnIndex);
        return resultSet.wasNull()?null:indexOf(index);
    }

    //用定义调用存储过程后，如何把数据库类型转换成java类型
    @Override
    public E getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int index = callableStatement.getInt(columnIndex);
        return callableStatement.wasNull()?null:indexOf(index);
    }

    private E indexOf(int index){
        try {
            return IndexEnumUtil.indexof(type,index);
        }catch (Exception e){
            throw new IllegalArgumentException("cannot convert "+index+" to"+type.getSimpleName()+" by index value.", e);
        }
    }
}
