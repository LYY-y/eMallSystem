package dao;

import com.eMall.dao.DiscountInfoDao;
import com.eMall.entity.DiscountInfo;
import com.eMall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DiscountInfoDaoTest {
    private DiscountInfoDao dao;
    private SqlSession session;

    @Before
    public void setUp(){
        session = MyBatisUtil.getSqlSession();
        dao = session.getMapper(DiscountInfoDao.class);
    }

    @After
    public void tearDown(){
        if (session != null){
            session.close();
        }
    }

    @Test
    public void testInsertDiscountInfo(){
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = format.parse("2020-05-25");
            endDate = format.parse("2020-06-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DiscountInfo discountInfo = new DiscountInfo("3000", "3", 0.7,"品牌活动",startDate,endDate);
        dao.insertDiscountInfo(discountInfo);
        session.commit();
    }

    @Test
    public void testDeleteDiscountInfoById(){
        dao.deleteDiscountInfoById("3000");
        session.commit();
    }

    @Test
    public void testUpdateDiscountInfo(){
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = format.parse("2020-05-25");
            endDate = format.parse("2020-06-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DiscountInfo discountInfo = new DiscountInfo("3000", "3", 0.75,"品牌活动",startDate,endDate);
        dao.updateDiscountInfo(discountInfo);
        session.commit();
    }

    @Test
    public void testSelectAllDiscountInfo(){
        List<DiscountInfo> list = dao.selectAllDiscountInfo();
        for (DiscountInfo discountInfo : list){
            System.out.println(discountInfo.toString());
        }
    }

    @Test
    public void testSelectDiscountInfoByEMall(){
        List<DiscountInfo> list = dao.selectDiscountInfoByEMall();
        for (DiscountInfo discountInfo : list){
            System.out.println(discountInfo.toString());
        }
    }

    @Test
    public void testSelectDiscountInfoByShop(){
        List<DiscountInfo> list = dao.selectDiscountInfoByShop();
        for (DiscountInfo discountInfo : list){
            System.out.println(discountInfo.toString());
        }
    }

    @Test
    public void testSelectDiscountInfoById(){
        DiscountInfo discountInfo = dao.selectDiscountInfoById("3000");
        System.out.println(discountInfo.toString());
    }

}
