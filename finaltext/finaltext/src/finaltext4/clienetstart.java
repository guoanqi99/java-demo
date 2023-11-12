package finaltext4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class clienetstart {
    public static void main(String[] args) throws Exception {
        client c=new client("e");
        //创建通道和服务器连接
        Socket soc=new Socket("127.0.0.1",8888);

        InputStream ips = soc.getInputStream();
        DataInputStream dai=new DataInputStream(ips);
        OutputStream ops = soc.getOutputStream();
        DataOutputStream dop = new DataOutputStream(ops);

        while (true){
            dop.writeUTF(c.name);
            dop.flush();

            String a=dai.readUTF();

            if(a.equals("很遗憾，活动结束")){
                System.out.println(a);
                ips.close();
                ops.close();
                soc.close();
                break;
            }else {
                System.out.println(a);
                int index=a.indexOf("：");
                int price= Integer.parseInt((a.substring(index + 1).trim()));
                c.setPrice(price);
            }
       }
    }
}
