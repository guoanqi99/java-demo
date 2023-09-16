package chengfabiao;

public class chengfabiaodemo {
    public static void main(String[] args) {
        int jieguo=0;
        for (int i = 1; i <10; i++) {
            for (int j = 1; j <10 ; j++) {
                if(i==j){
                    jieguo=i*j;
                    System.out.println( i+"*"+j+"="+jieguo);
                    break;
                }else if (j<i){
                    jieguo=i*j;
                    System.out.print( i+"*"+j+"="+jieguo+";");
                }
            }
        }

    }
}
