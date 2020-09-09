import com.eMall.entity.Order;
import com.eMall.entity.OrderCommodity;
import com.eMall.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest extends BaseTest{
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @Test
    public void testCreateOrder(){
        long order_id = 3L;
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

        long cid = 1647681248061664907L;
        int num = 2;
        BigDecimal single_price = new BigDecimal(5.2);
        BigDecimal total_price = new BigDecimal(5.2);
        OrderCommodity orderCommodity1 = new OrderCommodity(order_id, cid, num, single_price, total_price);
        cid = 2326051197328505845L;
        num = 2;
        single_price = new BigDecimal(5.2);
        total_price = new BigDecimal(5.2);
        OrderCommodity orderCommodity2 = new OrderCommodity(order_id, cid, num, single_price, total_price);
        cid = 5534719395229012749L;
        num = 2;
        single_price = new BigDecimal(5.2);
        total_price = new BigDecimal(5.2);
        OrderCommodity orderCommodity3 = new OrderCommodity(order_id, cid, num, single_price, total_price);
        List<OrderCommodity> list = new ArrayList<>();
        list.add(orderCommodity1);
        list.add(orderCommodity2);
        list.add(orderCommodity3);
        orderService.createOrder(order,list);
    }
}
