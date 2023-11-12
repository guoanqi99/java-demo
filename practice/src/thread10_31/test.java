package thread10_31;

public class test {
    public static void main(String[] args) {
        Runnable runnable=new Mythread();
        new Thread(runnable,"小明").start();
        new Thread(runnable,"小").start();

    }
}
