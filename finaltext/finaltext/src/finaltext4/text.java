package finaltext4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class text {

    public static void main(String[] args) throws Exception {
        //定义一个线程池
        ExecutorService pool=new ThreadPoolExecutor(5,10,
                0, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        hongbaochi hbc=new hongbaochi();

        //创建服务器端serversocket
        ServerSocket serverSocket=new ServerSocket(8888);

        while (true) {
            try {
                //等待客户端的连接请求
                Socket socket = serverSocket.accept();

                //建立请求后交给新线程
                new Qianghongbao(socket,hbc).start();
            } catch (IOException e) {
                System.out.println("活动已结束");
                serverSocket.close();
            }
        }
    }
}
