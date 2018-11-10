import com.hzed.qmqb.admin.AdminApplication;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/10
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
@EnableAutoConfiguration
public class BootTest {

    @SneakyThrows
    @Test
    public void userTest() {
        log.error("测试++===========================");
        log.error("测试++===========================");
        log.error("测试++===========================");
        log.error("测试++===========================");
        log.error("测试++===========================");
        log.error("测试++===========================");
        Thread.sleep(50000);
    }
}