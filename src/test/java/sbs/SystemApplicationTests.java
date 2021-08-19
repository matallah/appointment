package sbs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SystemApplication.class)
@WebAppConfiguration
@ComponentScan
public class SystemApplicationTests {

//   @Autowired private ExamsService examsService;

    @Test
    public void contextLoads() {

    }

}
