package finaltext2;

public class text {
    public static void main(String[] args) {
        tour t=new tour();//发起旅游
        //5次投票
        for (int i = 0; i < 3; i++) {
            t.vote();
        }
        //统计结果
        t.statistics();
        t.names();
    }
}
