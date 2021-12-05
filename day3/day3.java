import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day3 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day3/data3.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        // Read the file
        try {
            // Line by line

            String line;

            while ((line = input.readLine()) != null) {
                try {

                }

                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }


        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }

}

