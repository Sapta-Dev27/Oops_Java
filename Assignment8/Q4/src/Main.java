import java.util.*;

class Thread1 extends  Thread{
    @Override
    public void run(){
        System.out.println("Multiplication table of 2 :");
        for(int i=1 ; i<=10 ; i++){
            System.out.println( " Multiplication table of 2 : " + (i*2));
        }
    }
}
class Thread2 extends  Thread{
    @Override
    public void run(){
        System.out.println("Multiplication table of 5 :");
        for(int i=1 ; i<=10 ; i++){
            System.out.println( " Multiplication table of 5 : " + (i*5));
        }
    }
}

class Thread3 extends  Thread{
    @Override
    public void run(){
        System.out.println("Multiplication table of 10 :");
        for(int i=1 ; i<=10 ; i++){
            System.out.println( " Multiplication table of 10 : " + (i*10));
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();
        System.out.println("Thread-1 started");
        t1.start();
        try{
            t1.join();
        }
        catch (InterruptedException e){
            System.out.println("ERROR :" +e.getMessage());
        }
        System.out.println("Thread-2 started");
        t2.start();
        try{
            t2.join();
        }
        catch (InterruptedException e){
            System.out.println("ERROR :" +e.getMessage());
        }
        System.out.println("Thread-3 started");
        t3.start();
    }
}