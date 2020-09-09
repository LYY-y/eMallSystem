import com.eMall.service.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LoginServiceTest extends BaseTest{
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @Test
    public void testSellerLogin(){
        System.out.println(loginService.sellerLogin("admin","123abc"));
        System.out.println(loginService.sellerLogin("admin","123"));
    }
}
