package dao;

import com.eMall.dao.FreightInfoDao;
import com.eMall.entity.FreightInfo;
import com.eMall.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


public class FreightInfoDaoTest {
    private FreightInfoDao dao;
    private SqlSession session;

    @Before
    public void setUp(){
        session = MyBatisUtil.getSqlSession();
        dao = session.getMapper(FreightInfoDao.class);
    }

    @After
    public void tearDown(){
        if (session != null){
            session.close();
        }
    }

    @Test
    public void testInsertFeightInfo(){
        //由于fe_id是自增类型，先要获取最后一个fe_id值才可继续网上增加，否则从1开始计数
        for (int i = 0; i < 5; i++) {
            FreightInfo feightInfo = new FreightInfo(dao.seletLastFreightId().add(new BigInteger("1")),
                    "广"+i,"2",new BigDecimal(1.2), new BigDecimal(4), new BigDecimal(5),
                    new BigDecimal(6));
            dao.insertFreightInfo(feightInfo);
        }
        session.commit();
    }

    @Test
    public void testDeleteFreightInfoById(){
        for (int i = 11; i < 16; i++ ) {
            dao.deleteFreightInfoById(i+"");
        }
        session.commit();
    }

    @Test
    public void testUpdateFreightInfo(){
        FreightInfo feightInfo = new FreightInfo(new BigInteger("1"), "广东","广东",new BigDecimal(1),
                new BigDecimal(8), new BigDecimal(5),
                new BigDecimal(2));
        dao.updateFreightInfo(feightInfo);
        session.commit();
    }

    @Test
    public void testSelectAllFeightInfo(){
        List<FreightInfo> list = dao.selectAllFreightInfo();
        for (FreightInfo freightInfo : list){
            System.out.println(freightInfo.toString());
        }
    }

    @Test
    public void testSeletLastFreightId(){
        System.out.println(dao.seletLastFreightId());
    }

    @Test
    public void testSelectFreightInfoByFrom(){
        List<FreightInfo> list = dao.selectFreightInfoByFrom("广");
        for (FreightInfo freightInfo : list){
            System.out.println(freightInfo.toString());
        }
    }

    @Test
    public void testSelectFreightInfoByTo(){
        List<FreightInfo> list = dao.selectFreightInfoByTo("广");
        for (FreightInfo freightInfo : list){
            System.out.println(freightInfo.toString());
        }
    }

    @Test
    public void testSelectFreightInfoByFromAndTo(){
        FreightInfo freightInfo = dao.selectFreightInfoByFromAndTo("广东", "湖南");
        System.out.println(freightInfo.toString());
    }

}
