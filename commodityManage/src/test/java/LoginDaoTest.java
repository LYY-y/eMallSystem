import com.eMall.dao.LoginDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginDaoTest extends BaseTest{
    @Autowired
    private LoginDao dao;

    @Test
    public void testFindSellerPassword(){
        try {
            System.out.println(dao.findSellerPassword("admin"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
