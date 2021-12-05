import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day1 {
    public static void main(String[] args) {
        int count = 0;
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day1/data1.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        // Read the file
        try {
            // Line by line
            String line1 = input.readLine();
            String line2 = input.readLine();
            String line3;
            int prev = 0;
            while ((line1 != null && line2 != null) && (line3 = input.readLine()) != null) {
                try {
                    int sum = Integer.parseInt(line1) + Integer.parseInt(line2) + Integer.parseInt(line3);
                    if(sum > prev) {
                        count++;
                    }
                    line1 = line2;
                    line2 = line3;
                    prev = sum;
                }
                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }

        System.out.println(count);

        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }

}

