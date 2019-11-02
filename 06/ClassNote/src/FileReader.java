import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("test.txt");
        byte[] buffer = new byte[200]; //each time can only store 200 long
        int length = 0;
        //every time read from the source to buffer
        //each time put into buffer from 0 position to the length of 200
        //actual content is length
        //check if it returns -1 which means end of source
        while (-1 != (length = inputStream.read(buffer, 0, 200))) {
            String each = new String(buffer, 0, length);//now should know why need length variable
            System.out.println(each);
        }

        inputStream.close(); //all stream must close after using}
    }
}
