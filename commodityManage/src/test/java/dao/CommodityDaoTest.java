package dao;

import com.eMall.dao.CommodityDao;
import com.eMall.entity.Commodity;
import com.eMall.entity.DiscountInfo;
import com.eMall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommodityDaoTest {
    private CommodityDao dao;
    private SqlSession session;

    @Before
    public void setUp(){
        session = MyBatisUtil.getSqlSession();
        dao = session.getMapper(CommodityDao.class);
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
        Commodity commodity = new Commodity("005","3000","3","1","薯片",new BigDecimal(10), "3", "1000", 0.3, "广西",startDate,endDate, new BigDecimal(7.5));
        dao.insertCommodity(commodity);
        session.commit();
    }

    @Test
    public void testDeleteCommodityById(){
        dao.deleteCommodityById("005");
        session.commit();
    }

    @Test
    public void testUpdateCommodity(){
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = format.parse("2020-05-25");
            endDate = format.parse("2020-06-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Commodity commodity = new Commodity("005","3001","3","1","薯片",new BigDecimal(10), "3", "1000", 0.3, "广西",startDate,endDate, new BigDecimal(7.5));
        dao.updateCommodity(commodity);
        session.commit();
    }

    @Test
    public void testSelectAllDiscountInfo(){
        List<Commodity> list = dao.selectAllCommodities();
        for (Commodity commodity : list){
            System.out.println(commodity.toString());
        }
    }

    @Test
    public void testSelectCommoditySortByPriceASC(){
        List<Commodity> list = dao.selectCommoditySortByPriceASC();
        for (Commodity commodity : list){
            System.out.println(commodity.toString());
        }
    }
}
