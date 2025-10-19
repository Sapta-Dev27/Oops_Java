import java.io.*;
import java.util.*;

public class FileCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name :");
        String fileName = sc.nextLine();
        int lineCount = 0 , wordsCount =  0 , charCount = 0;
        try(BufferedReader br = new BufferedReader( new FileReader(fileName))){
          String line ;
          while((line = br.readLine()) != null){
              lineCount++;
              charCount = charCount + line.length();
              String[] words = line.trim().split("\\s+");
              if(!line.trim().isEmpty()){
                  wordsCount = wordsCount + words.length;
              }
          }
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordsCount);
        }
        catch(FileNotFoundException e1){
            System.out.println("File not found :" + e1.getMessage());
        }
        catch(IOException e2){
            System.out.println("IO Exception :" + e2.getMessage());
        }
    }
}

/* explanation of the Code :
1. BufferReader : It is a reader thats reads chars efficently more than a FileReader as it reads chunks of texts and SAves it to
the buffer and later feeds to the program rather than char by char which is slow .
2. readLine() : reads a line in BufferReader. Returns null if it had reached the end of the file.
3. line.trim() function trims the trailing and leading whitespaces
4. trim.split("//s+") : convents the line into a array of words ( based on a Regular Expression : //s which is a whitespace
and + is used to determine one or more occurances of whitespace
 */