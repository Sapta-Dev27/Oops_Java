import java.util.*;

class Thread1 extends  Thread{
    @Override
    public void run(){
        for(int i=1 ; i<=10 ; i++){
            System.out.println(i + " From Thread-1");
        }
    }
}
class Thread2 extends  Thread{
    @Override
    public void run(){
        for(int i=11 ; i<=20 ; i++){
            System.out.println(i + " From Thread-2");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        System.out.println("Thread-1 started");
        t1.start();
        System.out.println("Thread-2 started");
        t2.start();
    }
}