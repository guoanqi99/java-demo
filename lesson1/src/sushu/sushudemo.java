package sushu;

public class sushudemo {
    public static void main(String[] args) {
        System.out.println(sushu(101, 200));
    }
    //输入a=101,b=200
    public static int sushu(int a, int b){
        int sum=0;

        h:
        for (int i = a; i <=b ; i++) {
            for (int j = 2; j <i/2 ; j++) {
                if (i % j == 0){
                    continue h;
                }
            }
            sum+=1;
        }
        return sum;
    }
}
