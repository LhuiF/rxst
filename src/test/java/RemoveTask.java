import com.unionx.core.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;

/**
 * @author abner
 */
@Slf4j
public class RemoveTask implements Runnable {

    public void run() {
        try {
            Thread.sleep(60000);
        } catch (Exception e) {
            log.error("",e);
        }
    }

    public static void main(String[] args) {
        Runnable removeTask = new RemoveTask();
        Thread thread = new Thread(removeTask);
        thread.start();
    }
}
