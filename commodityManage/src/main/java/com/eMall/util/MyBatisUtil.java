package com.eMall.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//创建工具类，SqlSession对象为单例模式
public class MyBatisUtil {
    private static SqlSessionFactory factory;

    public static SqlSession getSqlSession(){
        try {
            //读取主配置文件，参数为主配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSession工厂
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回创建的SqlSession对象
        return factory.openSession();
    }
}
