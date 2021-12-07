import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day7 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day7/day7.txt"));
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
                    String[] clean = line.split(",");
                    for(String s : clean) {
                        numbers.add(Integer.parseInt(s));
                    }
                }
                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }

        int minSum = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 0; i < numbers.size(); i++) {
            int currentSum = 0;

            for(int j = 0; j < numbers.size(); j++) {
                for(int k = 1; k <= Math.abs(numbers.get(i) - numbers.get(j)); k++) {
                    currentSum += k;
                }
            }

            if(currentSum < minSum) {
                minSum = currentSum;
                minIndex = i;
            }
        }

        System.out.println(minIndex + " : " + minSum);


        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }


}

