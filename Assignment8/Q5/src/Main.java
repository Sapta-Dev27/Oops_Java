import java.util.*;

class SharedResource{
   int value ;
   boolean hasValue=false;
   SharedResource(int value){
       this.value=value;
   }
   public synchronized  void produce(int num){
       while(hasValue){
           try{
               wait();
           }
           catch (InterruptedException e1){
               System.out.println("Error :" +e1.getMessage());
           }
       }
       value = num ;
       System.out.println(value + " is produced");
       hasValue=true;
       notify();
   }
   public synchronized  int consume(){
       while(!hasValue){
           try{
               wait();
           }
           catch (InterruptedException e1){
               System.out.println("Error :" +e1.getMessage());
           }
       }
       hasValue=false;
       notify();
       return value;
   }
}

class ProducerThread extends  Thread{
    SharedResource data ;
    ProducerThread(SharedResource data){
        this.data = data ;
    }
    @Override
    public void run(){
        for(int i=1 ; i <=10 ; i++){
            data.produce(i);
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e1){
                System.out.println("Error :" +e1.getMessage());
            }
        }
    }
}

class ConsumerThread extends Thread{
    SharedResource data;
    ConsumerThread(SharedResource data){
        this.data=data;
    }
    @Override
    public void run(){
        for(int i=1 ; i <=10 ; i++){
           int consumed = data.consume();
            System.out.println(consumed + " is consumed");
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e1){
                System.out.println("Error :" +e1.getMessage());
            }
        }
    }
}

public class Main{
    public static void main(String[] args) {
            SharedResource r1 = new SharedResource(0);
            ProducerThread p1 = new ProducerThread(r1);
            ConsumerThread c1 = new ConsumerThread(r1);
            p1.start();
            c1.start();
    }
}