package shuangseqiu;

import java.util.Scanner;

public class shuangseqiuDemo {
    public static void main(String[] args) {
    }
    public  static int[] xuanhao(){
        Scanner sca=new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("请选择您的第" + i + "个红球号码（要求在1-33之间，不能重复");
            int num= sca.nextInt();
        }
    }
}
