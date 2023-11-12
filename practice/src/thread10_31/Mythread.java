package thread10_31;

public class Mythread implements Runnable {
    present p = new present();

    @Override
    public void run() {
        int number = 0;
        while (true) {
            synchronized (p) {
                if (p.count < 10) {
                   break;
                }
                p.devide();
                number++;
            }
        }
        System.out.println(Thread.currentThread().getName() + "分发数量：" + number);
    }
}
