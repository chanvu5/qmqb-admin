import com.hzed.qmqb.admin.AdminApplication;
import com.hzed.qmqb.admin.application.service.FileService;
import com.hzed.qmqb.admin.infrastructure.utils.PicUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FileService fileService;

/*    @SneakyThrows
    @Test
    public void userTest() {
        log.error("测试++===========================");
        log.error("测试++===========================");
        Thread.sleep(50000);
    }*/

    @Test
    public void uploadImg() throws Exception {
        String imgPath = "C:/imgUpload/20180730101615.jpg";
        String base64String = PicUtil.picToBase64(imgPath);
        String path = fileService.uploadBase64Img(base64String, "jpg");
        System.out.println(path);
    }

}