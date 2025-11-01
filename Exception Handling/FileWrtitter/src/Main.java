import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String fileName = sc.next();
        /*here we have used try with resources . SO we dont need to take care of the FINAL code block.
        All the closing of resources is handled by try with resources

        try(FileWriter writter = new FileWriter(fileName)){
             writter.write("HELLO WORLD");
             writter.flush();
        }
        catch (IOException e){
            System.out.println("Exception occured" +e.getMessage());
        }
        */
        /*Here what we have done is that we have definded the FileWritter inside the try block . Hence we have
        to explicity close the resources inside the FINAL Block. Inside the final block of code , we have to again
        do some try-catch in order to catch some exceptions that occurs while closing the file .
         */
        FileWriter writter = null;
        try{
             writter = new FileWriter(fileName);
             writter.write("Hello World From new file");
        }
        catch (IOException e) {
            System.out.println("Error occured while writing file" +e.getMessage());
        }
        finally {
            try{
                if(writter != null){
                    writter.close();
                }
            }
            catch (IOException e1){
                System.out.println("Error occured while closing file" +e1.getMessage());
            }
        }
    }
}