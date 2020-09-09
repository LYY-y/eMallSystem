import com.eMall.dao.FreightInfoDao;
import com.eMall.entity.FreightInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FreightInfoDaoTest extends BaseTest {
    @Autowired
    FreightInfoDao freightInfoDao;

    @Test
    public void testSelectOneCommodityInfoById(){
        FreightInfo freightInfo =freightInfoDao.selectFreightInfoByFromAndTo("广东","北京");
        System.out.println( freightInfo.toString());
    }
}
