import java.util.*;
import java.io.*;

public class FileAppend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file:");
        String fileName = sc.nextLine();
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            System.out.println("Enter the contents you want to add to the file:");
            String content = sc.nextLine();
            writer.write("\n" + content);
        }
        catch(IOException e1){
            System.out.println("Error while writing to file :" +e1.getMessage());
        }
        finally {
          try {
              if(writer != null){
                  writer.close();
              }
          }
          catch (IOException e2){
              System.out.println("Error while closing file :" +e2.getMessage());
          }
        }
    }
}