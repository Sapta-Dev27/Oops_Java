import java.io.*;
import java.util.*;

public class FileCopy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of Destination File:");
        String fileName = sc.nextLine();
        FileReader reader = null;
        FileWriter writer =  null;
        try {
            System.out.println("Enter the name of Source File:");
            String fileName2 = sc.nextLine();
            reader = new FileReader(fileName2);
            writer = new FileWriter(fileName);
            int data ;
            while((data =reader.read()) != -1){
                writer.write(data);
            }
        }
        catch(FileNotFoundException e1){
            System.out.println(" Source File not found " +e1.getMessage());
        }
        catch (IOException e2){
            System.out.println(" Source File I/O Error " +e2.getMessage());
        }
        finally {
            try {
                if(reader != null){
                    reader.close();
                }
                if(writer != null){
                    writer.close();
                }
            }
            catch(IOException e){
                System.out.println("Error in closing the file :" +e.getMessage());
            }
        }
    }
}