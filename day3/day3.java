import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day3 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day3/day3.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        Map<Integer, Map<Integer, Integer>> track = new HashMap<>();
        Set<String> oxygen = new HashSet<>();
        Set<String> co2 = new HashSet<>();

        // Read the file
        try {
            // Line by line

            String line;
            while ((line = input.readLine()) != null) {
                oxygen.add(line);
                co2.add(line);
                try {
                    for(int i = 0 ; i < line.length(); i++) {
                        int c = Integer.parseInt(line.substring(i, i+1));
                        if(!track.containsKey(i)) track.put(i, new HashMap<>());
                        if(!track.get(i).containsKey(c)) track.get(i).put(c, 0);
                        track.get(i).put(c, track.get(i).get(c) + 1);
                    }
                }

                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }

        System.out.println(track);

        String gamma = "";
        String epsilon = "";

        for(Integer i: track.keySet()) {
            Map<Integer, Integer> m = track.get(i);
            if(m.get(0) > m.get(1)) {
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }

        System.out.println("product : " + Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));

        int indx = 0;
        while(oxygen.size() > 1) {
            int zero = 0;
            int one = 0;
            Set<String> newOxygen = new HashSet<>();

            for(String s : oxygen) {
                if(s.substring(indx, indx+1).equals("0")) zero++;
                else one++;
            }

            if(zero > one) {
                for(String s : oxygen) {
                    if(s.substring(indx, indx+1).equals("0")) newOxygen.add(s);
                }
            } else {
                for(String s : oxygen) {
                    if(s.substring(indx, indx+1).equals("1")) newOxygen.add(s);
                }
            }

            indx++;
            oxygen = newOxygen;
        }

        String oxygenFinal = oxygen.iterator().next();

        indx = 0;
        while(co2.size() > 1) {
            int zero = 0;
            int one = 0;
            Set<String> newCo2 = new HashSet<>();

            for(String s : co2) {
                if(s.substring(indx, indx+1).equals("0")) zero++;
                else one++;
            }

            if(zero > one) {
                for(String s : co2) {
                    if(s.substring(indx, indx+1).equals("1")) newCo2.add(s);
                }
            } else {
                for(String s : co2) {
                    if(s.substring(indx, indx+1).equals("0")) newCo2.add(s);
                }
            }

            indx++;
            co2 = newCo2;

        }

        String co2Final = co2.iterator().next();

        System.out.println(oxygenFinal + " " + co2Final);
        System.out.println(Integer.parseInt(oxygenFinal, 2) * Integer.parseInt(co2Final, 2));

        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }

}

