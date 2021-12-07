import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day6 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day6/day6.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        long[] fish = new long[9];
        // Read the file
        try {

            String line;

            while ((line = input.readLine()) != null) {
                try {
                    String[] nums = line.split(",");
                    for(String s :nums) {
                        fish[Integer.parseInt(s)]++;
                    }
                }
                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }


        for(int day = 0; day < 256; day++) {
            long track = fish[0];
            fish[0] = fish[1];
            fish[1] = fish[2];
            fish[2] = fish[3];
            fish[3] = fish[4];
            fish[4] = fish[5];
            fish[5] = fish[6];
            fish[6] = fish[7] + track;
            fish[7] = fish[8];
            fish[8] = track;
        }

        long count = 0;
        for(int i = 0; i < fish.length; i++) count += fish[i];

        System.out.println("Total Fish: " + count);



        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }


}

