import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day8 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day8/day8-example.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        // Read the file
        try {

            String line;

            while ((line = input.readLine()) != null) {
                try {
                    System.out.println(line);
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

