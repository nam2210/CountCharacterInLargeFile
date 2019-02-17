import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadLargeFile {

    public static void main(String[] arg) {
        //to read file line by line

        String path = "/Users/nampham/Desktop/test_sample";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            long start = System.currentTimeMillis();
            long[] result = new long[26];
            for (int i = 0; i < 26; i++){
                result[i] = 0;
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                findCharacters(result, line);
            }
            System.out.println((System.currentTimeMillis() - start));
            printResult(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }


    private static void findCharacters(long[] result, String line) {
        int length = line.length();
        line = line.toLowerCase();
        for (int i = 0; i < length; i++) {
            int index = (int) line.charAt(i) - 97;
            if (index >= 0 && index <= 25) {
                result[index] += 1;
            }
        }
    }

    private static void printResult(long[] result){
        for (int i = 0; i < result.length; i++){
            System.out.println((char) (i+97) + "=" + result[i]);
        }
    }
}
