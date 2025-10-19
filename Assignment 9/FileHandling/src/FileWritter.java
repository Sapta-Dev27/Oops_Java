import java.util.*;
import java.io.*;

public class FileWritter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file :");
        String fileName = sc.nextLine();
        FileWriter writter = null;
        try{
            writter = new FileWriter(fileName);
            System.out.println("Enter the contents of the file : ");
            String content = sc.nextLine();
            writter.write(content);
        }
        catch(IOException e){
            System.out.println("Error in Writting file : " +e.getMessage());
        }
        finally {
         try{
           if(writter != null){
               writter.close();
           }
         }
         catch (Exception e){
             System.out.println("Error in closing file : " +e.getMessage());
         }
        }
        sc.close();
    }
}