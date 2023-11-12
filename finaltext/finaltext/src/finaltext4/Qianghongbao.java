package finaltext4;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Qianghongbao extends Thread{
    private Socket socket;
    private hongbaochi hbc;

    int price;//红包金额

    Random r=new Random();

    public Qianghongbao(Socket socket,hongbaochi hbc) {
        this.socket = socket;
        this.hbc = hbc;
    }

    @Override
    public  synchronized void run() {
        //接受客户端请求
        try {
            InputStream in=socket.getInputStream();
            DataInputStream dis=new DataInputStream(in);
            OutputStream ops = socket.getOutputStream();
            DataOutputStream dop = new DataOutputStream(ops);

            while (true) {
                String tname= dis.readUTF();
                //抢红包
                if(hbc.p>20){
                    String m="很遗憾，活动结束";
                    dis.close();
                    socket.close();
                }
                hbc.p++;
                int i=r.nextInt(0,20-hbc.p);
                price=hbc.hb.remove(i);

                dop.writeUTF(tname+"恭喜您,抢到红包："+price);

                Thread.sleep(3000);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
