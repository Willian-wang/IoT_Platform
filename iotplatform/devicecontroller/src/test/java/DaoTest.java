import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.platform.device.DeviceControllerBoot;
import com.heiyu.platform.device.dao.ProductInfMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Mybatisƒ£øÈ≤‚ ‘¿‡
 * @author WangYi
 * @date 16:19 2019/8/8
 * @version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DeviceControllerBoot.class)
@WebAppConfiguration
public class DaoTest {

    @Autowired
    private ProductInfMapper deviceInfMapper;

    private ObjectMapper objectMapper =new ObjectMapper();

    @Test
    public void daoTest() throws JsonProcessingException {
//        System.out.println(objectMapper.writeValueAsString(deviceInfMapper.getAll()));
    }
}
