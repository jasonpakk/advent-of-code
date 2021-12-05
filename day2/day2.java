import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day2/data2.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        int horz = 0;
        int depth = 0;
        int aim = 0;

        // Read the file
        try {
            // Line by line

            String line;

            while ((line = input.readLine()) != null) {
                try {
                    String[] vals = line.split(" ");
                    int num = Integer.parseInt(vals[1]);

                    if(vals[0].equals("forward")) {
                        horz += num;
                        depth += aim * num;
                    } else if (vals[0].equals("up")) {
                        aim -= num;
                    } else {
                        aim += num;
                    }
                }

                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }

        System.out.println(horz * depth);

        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }

}

