import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;
import com.eMall.entity.enums.Promotion;
import com.eMall.entity.enums.State;
import com.eMall.service.CommodityService;
import com.eMall.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class CommodityServiceTest extends BaseTest{
    @Autowired
    @Qualifier("commodityService")
    private CommodityService service;

//    @Before
//    public void setUp(){
//        //获取容器
//        String path=System.getProperty("user.dir");
////        ApplicationContext context=new FileSystemXmlApplicationContext(path+"//commodityManage/src/main/resources/applicationContext.xml");
////        CommodityService service = (CommodityService) context.getBean("commodityService");
//        // 创建IOC配置文件的抽象资源
//        Resource resource = new ClassPathResource("applicationContext.xml");
//        // 创建一个BeanFactory
//        BeanFactory factory = new DefaultListableBeanFactory();
//        //把读取配置信息的BeanDefinitionReader,这里是XmlBeanDefinitionReader配置给BeanFactory
//        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
//        //从定义好的资源位置读入配置信息，具体的解析过程由XmlBeanDefinitionReader来完成
//        beanDefinitionReader.loadBeanDefinitions(resource);
//        //从容器中获取对象
//        service = (CommodityService) factory.getBean("commodityService");
//    }

    @Test
    public void testAuditCommodityInfo(){
        long commodity_id = 1;
        int brand_id = 1;
        int category_id = 1;
        java.lang.String title = "test2";
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
        Timestamp publish_time = Timestamp.valueOf("2020-10-10 00:00:00.000");
        int promotion_per_limit = 5;
        Long cid = RandomNumUtil.createId();
        Promotion promotion_type = Promotion.valueOf("EMALL");
        long shop_id = 1L;
        String main_pic = "test";
        String place = "广州";
        Commodity commodity = new Commodity(commodity_id, category_id,brand_id,title,status,sale,price,promotion_price,
                description,stock,weight,keywords,promotion_start_time,promotion_end_time,promotion_per_limit,
                promotion_type,publish_time,shop_id, main_pic,cid,place);
        Long img_id = RandomNumUtil.createId();
        java.lang.String pic_path = "test";
        CommodityPic commodityPic = new CommodityPic(img_id, pic_path, 1);
        service.addCommodity(commodity, new CommodityPic[]{commodityPic}, cid);
    }

    @Test
    public void testFindAllCommodities(){
        List<Commodity> list = service.findAllCommodities();
        for (Commodity commodity : list){
            System.out.println(commodity.toString());
        }
    }

    @Test
    public void testDeleteCommodity(){
        service.deleteCommodity("6654998195560234721");
    }
//
//    @Test
//    public void testUpdateCommodity(){
//        Date startDate = null;
//        Date endDate = null;
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            startDate = format.parse("2020-05-25");
//            endDate = format.parse("2020-06-08");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Commodity commodity = new Commodity("006","3001","3","1","巧克力",new BigDecimal(10), "3", "1000", 0.3, "广西",startDate,endDate, new BigDecimal(7.5));
//        service.updateCommodityInfo(commodity);
//    }
//


//    @Test
//    public void testSelectCommoditySortByPriceASC(){
//        List<Commodity> list = service.lookUpAllCommoditiesByPriceOrder();
//        for (Commodity commodity : list){
//            System.out.println(commodity.toString());
//        }
//    }

    @Test
    public void testSelectOneCommodityInfoById(){
        Commodity commodity=service.findOneCommodity("1148372028738014313");
        System.out.println(commodity.toString());
    }
}

