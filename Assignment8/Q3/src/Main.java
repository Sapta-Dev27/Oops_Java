import java.util.*;

class Thread1 extends  Thread{
    @Override
    public void run(){
        for(int i=10 ; i>=1 ; i--){
            System.out.println(i + " From Thread");
            try{
                sleep(1000);
            }
            catch (InterruptedException e1){
                System.out.println("Error :" +e1.getMessage());
            }

        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        System.out.println("Current state of thread :" +t1.getState());
        System.out.println("Thread started");
        t1.start();
    }
}