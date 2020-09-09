import com.eMall.dao.CommodityDao;
import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;
import com.eMall.entity.enums.Promotion;
import com.eMall.entity.enums.State;
import com.eMall.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class CommodityDaoTest extends BaseTest {
    @Autowired
    private CommodityDao dao;

    @Test
    public void testInsertDiscountInfo(){
        long cid = RandomNumUtil.createId();
        long commodity_id = 1;
        int brand_id = 1;
        int category_id = 1;
        java.lang.String title = "test";
        State status = State.valueOf("SALING");
        int sale = 0;
        BigDecimal price = new BigDecimal(9);
        BigDecimal promotion_price = new BigDecimal(8);
        java.lang.String description = "test";
        int stock = 100;
        BigDecimal weight = new BigDecimal(0.5);
        java.lang.String keywords = "test";
        Timestamp promotion_start_time = new Timestamp(System.currentTimeMillis());
        Timestamp promotion_end_time = Timestamp.valueOf("2020-10-10 00:00:00.000");
        int promotion_per_limit = 5;
        Promotion promotion_type = Promotion.valueOf("EMALL");
        Timestamp publish_time = Timestamp.valueOf("2020-10-10 00:00:00.000");
        long shop_id = 1L;
        String main_pic ="test";
        String place = "广州";

        Commodity commodity = new Commodity(commodity_id, brand_id, category_id,title,status,sale,price,promotion_price,
                description,stock,weight,keywords,promotion_start_time,promotion_end_time,promotion_per_limit, promotion_type,
                publish_time,shop_id, main_pic,cid,place);
        dao.insertCommodity(commodity);
    }

    @Test
    public void testInsertCommodityPic() {
        Long img_id = RandomNumUtil.createId();
        java.lang.String pic_path = "test";
        int order = 1;

        CommodityPic commodityPic = new CommodityPic(img_id,pic_path,order);
        dao.insertCommodityPic(commodityPic, 1285684457715569471L);
    }

    @Test
    public void testSelectAllDiscountInfo(){
        List<Commodity> list = dao.selectAllBasicCommodities();
        for (Commodity commodity : list){
            System.out.println(commodity.toString());
        }
    }

    @Test
    public void testSelectCommodityAllPics(){
        List<String> list = dao.selectCommodityAllPics(6309140051100882121L);
        for (String pic_path : list){
            System.out.println(pic_path);
        }
    }


    @Test
    public void testDeleteCommodityById(){
        dao.deleteCommodityById(2624276944197910415L);
    }

    @Test
    public void testUpdateCommodity(){
        long cid = 1148372028738014313L;
        long commodity_id = 456;
        int brand_id = 1;
        int category_id = 1;
        String title = "test";
        State status = State.valueOf("SALING");
        int sale = 0;
        BigDecimal price = new BigDecimal(9);
        BigDecimal promotion_price = new BigDecimal(8);
        java.lang.String description = "test";
        int stock = 100;
        BigDecimal weight = new BigDecimal(0.5);
        java.lang.String keywords = "test";
        Timestamp promotion_start_time = new Timestamp(System.currentTimeMillis());
        Timestamp promotion_end_time = Timestamp.valueOf("2020-10-10 00:00:00.000");
        int promotion_per_limit = 5;
        Promotion promotion_type = Promotion.valueOf("EMALL");
        Timestamp publish_time = Timestamp.valueOf("2020-10-10 00:00:00.000");
        long shop_id = 1L;
        String main_pic ="test";
        String place = "广州";
        Commodity commodity = new Commodity(commodity_id, brand_id, category_id,title,status,sale,price,promotion_price,
                description,stock,weight,keywords,promotion_start_time,promotion_end_time,promotion_per_limit, promotion_type,
                publish_time,shop_id, main_pic,cid,place);
        dao.updateCommodity(commodity);
    }

    @Test
    public void testSelectOneCommodityInfoById(){
        Commodity commodity=dao.selectOneCommodityInfoById(1148372028738014313L);
        System.out.println(commodity.toString());
    }

//
//    @Test
//    public void testSelectCommoditySortByPriceASC(){
//        List<Commodity> list = dao.selectCommoditySortByPriceASC();
//        for (Commodity commodity : list){
//            System.out.println(commodity.toString());
//        }
//    }
}
