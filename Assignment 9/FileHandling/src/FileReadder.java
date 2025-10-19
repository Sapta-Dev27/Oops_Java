import java.util.*;
import java.io.*;

public class FileReadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileReader reader = null;
        try{
            System.out.println("Enter the name of the file : ");
            String fileName = sc.nextLine();
           reader = new FileReader(fileName);
           int data ;
           while(( data = reader.read()) != -1){
               System.out.print((char)data);
           }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found :" +e.getMessage());
        }
        catch (IOException e){
            System.out.println("Error in reading file :" +e.getMessage());
        }
        finally {
            try{
               if(reader != null){
                   reader.close();
               }
            }
            catch (Exception e){
                System.out.println("Error in closing file :" +e.getMessage());
            }
        }
    }
}