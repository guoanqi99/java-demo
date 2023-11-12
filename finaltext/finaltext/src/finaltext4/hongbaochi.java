package finaltext4;

import java.util.LinkedList;
import java.util.Random;

public class hongbaochi {
    LinkedList<Integer> hb=new LinkedList<>();

    int p;//已抢数量

    //随机生成200个红， 80%金额小于30,20%金额大于30
    public hongbaochi() {
        Random r=new Random();
        int min=0;
        int max=0;
        //循环随机生成金额,直到红包池填满
         while(true) {
            int p=r.nextInt(1,101);
            if(p<=30&&min<16){
                hb.add(p);
                min++;
            }
            if(p>30&&p<=100&&max<4){
                hb.add(p);
                max++;
            }
            if(min==16&&max==4){
                break;
            }
        }
         //hb.forEach(s->System.out.println(s));
    }

}
