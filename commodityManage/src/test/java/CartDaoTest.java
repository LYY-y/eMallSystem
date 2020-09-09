import com.eMall.dao.CartDao;
import com.eMall.entity.Cart;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class CartDaoTest extends BaseTest {
    @Autowired
    private CartDao cartDao;

    @Test
    public void testInsertCart(){
        long buy_id = 1L;
        long shop_id = 1L;
        long cid = 807215550018678418L;
        int num = 1;
        BigDecimal total_price = new BigDecimal(158.00);
        Timestamp cart_time = new Timestamp(System.currentTimeMillis());
        int cart_state = 0;
        Cart cart = new Cart(buy_id,shop_id,cid,num,total_price,cart_time,cart_state);
        try {
            cartDao.insertCart(cart);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectAllCartItemsByBuyerId(){
        System.out.println(cartDao.selectAllCartItemsByBuyerId(1L));
    }
}
