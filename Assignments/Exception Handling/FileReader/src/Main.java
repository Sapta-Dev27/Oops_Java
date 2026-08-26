import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to read: ");
        String fileName = sc.next();
        FileReader reader = null;
        try{
            int data ;
            reader = new FileReader(fileName);
            while( (data =reader.read()) != -1){
                System.out.print((char)data);
            }
        }
        catch (FileNotFoundException  e){
            System.out.println("ERROR OCCURED : FILE SPECIFIED NOT FOUND " +e.getMessage());
        }
        catch (IOException e){
            System.out.println("ERROR OCCURED" +e.getMessage());
        }
        finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }
            catch (IOException e){
                System.out.println("ERROR OCCURED" +e.getMessage());
            }
        }
    }
}