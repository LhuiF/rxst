import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jayson on 2016/4/28 0028.
 */
public class Log4jServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(4560);
        while (true) {
            System.out.println("服务启动！");
            Socket client = socket.accept();
            System.out.println("接受连接。。。。");
            Thread t = new Thread(new LogRunner(client));
            t.start();
        }
    }
}

class LogRunner implements Runnable {
    private ObjectInputStream ois;
    private String ip;
    public LogRunner(Socket client) {
        try {
            ip = client.getInetAddress().toString();
            this.ois = new ObjectInputStream(client.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("[%p:%d %l]%n\t%m%n");
        try {
            while (true) {
                LoggingEvent event = (LoggingEvent) ois.readObject();
                StringBuilder sbuf = new StringBuilder();
                String fullInfo = event.getLocationInformation().fullInfo;
                sbuf.append(event.getLevel().toString()).append("\n");
                sbuf.append("[" + event.getLoggerName() + "]").append("\n");
                sbuf.append(fullInfo).append("\n");
                sbuf.append("[" + event.getThreadName() + "]").append("\n");
                sbuf.append(event.getRenderedMessage()).append("\n");
                sbuf.append("------------------------------------------------\n\n");

                System.out.println(sbuf.toString());
                //String format = layout.format(event);
                //System.out.println(format);


            }
        } catch (java.io.EOFException e) {
            e.printStackTrace();
            //读取的时候到达尾端抛出的异常，屏蔽掉
        } catch (java.net.SocketException e) {
            e.printStackTrace();
        } catch (InterruptedIOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}