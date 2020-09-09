import com.eMall.service.FreightService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FreightServiceTest extends BaseTest {
    @Autowired
    @Qualifier("freightService")
    private FreightService freightService;

    @Test
    public void testFindFreightInfoByFromAndTo(){
        System.out.println(freightService.findFreightInfoByFromAndTo("广东","北京"));
    }
}
