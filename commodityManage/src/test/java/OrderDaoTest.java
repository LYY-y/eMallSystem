import com.eMall.dao.OrderDao;
import com.eMall.entity.Commodity;
import com.eMall.entity.Order;
import com.eMall.entity.OrderCommodity;
import com.eMall.entity.enums.Promotion;
import com.eMall.entity.enums.State;
import com.eMall.util.RandomNumUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderDaoTest extends BaseTest{
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsertOrder(){
        long order_id = 2L;
        long buyer_id = 1L;
        long shop_id = 1L;
        String from_place = "广州";
        String dest_place = "北京";
        Timestamp order_time = new Timestamp(System.currentTimeMillis());
        String receiver_name = "小龙";
        String receiver_phone = "12345678996";
        int order_state = 0;
        int pay_method = 0;
        BigDecimal freight = new BigDecimal(10);
        BigDecimal all_price = new BigDecimal(12);
        BigDecimal real_pay = new BigDecimal(11);
        Order order = new Order(order_id,buyer_id,shop_id,from_place,dest_place,order_time,receiver_name,receiver_phone,
                order_state,pay_method,freight,all_price,real_pay);
        orderDao.insertOrder(order);
    }

    @Test
    public void testInsertOrderCommodity(){
        long order_id = 1L;
        long cid = 5534719395229012749L;
        int num = 2;
        BigDecimal single_price = new BigDecimal(5.2);
        BigDecimal total_price = new BigDecimal(5.2);
        OrderCommodity orderCommodity = new OrderCommodity(order_id, cid, num, single_price, total_price);
        orderDao.insertOrderCommodity(orderCommodity);
    }

    @Test
    public void testFindOrderByBuyer(){
        List<Order> list = orderDao.findOrderByBuyer(1L);
         for (Order order:list){
             System.out.println(order.toString());
         }
    }

    @Test
    public void testFindOrderCommodityByOrder(){
        List<OrderCommodity> list = orderDao.findOrderCommodityByBuyer(2L);
        for (OrderCommodity orderCommodity:list) {
            System.out.println(orderCommodity.toString());
        }
    }



}
