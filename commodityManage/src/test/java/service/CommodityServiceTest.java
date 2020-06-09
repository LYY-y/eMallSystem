package service;

import com.eMall.entity.Commodity;
import com.eMall.service.CommodityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CommodityServiceTest {
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
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate = format.parse("2020-05-25");
            endDate = format.parse("2020-06-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Commodity commodity = new Commodity("006","3000","3","1","巧克力",new BigDecimal(10), "3", "1000", 0.3, "广西",startDate,endDate, new BigDecimal(7.5));
        service.auditCommodityInfo(commodity);
    }

}
