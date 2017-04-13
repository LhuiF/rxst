import com.unionx.core.file.FileStorageManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jayson on 16-9-13.
 */
public class FileUploadTest {

    @Test
    public void upload() throws Exception {
        System.out.println("上传文件测试:");
        FileStorageManager fileStorageManager = new FileStorageManager();
        String trackerServerAddr = fileStorageManager.getTrackerServerAddr();
        System.out.println("文件服务器地址:"+trackerServerAddr);
        String upload = fileStorageManager.upload("aaa".getBytes(), "test.txt");
        System.out.println("<==========上传文件返回结果=========>\n"+upload);

    }
}
