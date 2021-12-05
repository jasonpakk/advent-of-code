import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class day5 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day5/data5.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        Map<Point, Integer> points = new HashMap<>();

        // Read the file
        try {

            String line;

            while ((line = input.readLine()) != null) {
                try {

                    // parse input string
                    int index = line.indexOf(" -> ");
                    String[] left = line.substring(0, index).split(",");
                    String[] right = line.substring(index + 4).split(",");

                    // obtain coordinates
                    int x1 = Integer.parseInt(left[0]);
                    int y1 = Integer.parseInt(left[1]);
                    int x2 = Integer.parseInt(right[0]);
                    int y2 = Integer.parseInt(right[1]);

                    // vertical line
                    if(x1 == x2) {
                        int ymin = Math.min(y1, y2);
                        int ymax = Math.max(y1, y2);
                        for(int i = ymin; i <= ymax; i++) {
                            Point p = new Point(x1, i);
                            if(!points.containsKey(p)) points.put(p, 0);
                            points.put(p, points.get(p) + 1);
                        }
                    }

                    // horizontal line
                    else if(y1 == y2) {
                        int xmin = Math.min(x1, x2);
                        int xmax = Math.max(x1, x2);
                        for(int i = xmin; i <= xmax; i++) {
                            Point p = new Point(i, y1);
                            if(!points.containsKey(p)) points.put(p, 0);
                            points.put(p, points.get(p) + 1);
                        }
                    }

                    // diagonal line
                    else {
                        if((x1 < x2 && y1 < y2) || (x1 > x2 && y1 > y2)) {
                            for(int i = 0; i <= Math.abs(y2 - y1); i++) {
                                Point p = new Point(Math.min(x1, x2) + i, Math.min(y1, y2) + i);
                                if(!points.containsKey(p)) points.put(p, 0);
                                points.put(p, points.get(p) + 1);
                            }
                        } else if(x1 > x2 && y1 < y2) {
                            for(int i = 0; i <= (y2 - y1); i++) {
                                Point p = new Point(x1 - i, y1 + i);
                                if(!points.containsKey(p)) points.put(p, 0);
                                points.put(p, points.get(p) + 1);
                            }
                        } else {
                            for(int i = 0; i <= (y1 - y2); i++) {
                                Point p = new Point(x1 + i, y1 - i);
                                if(!points.containsKey(p)) points.put(p, 0);
                                points.put(p, points.get(p) + 1);
                            }
                        }
                    }
                }

                catch (NumberFormatException e) {
                    System.err.println("bad number");
                }
            }
        } catch (IOException e) {
            System.err.println("IO error while reading.\n" + e.getMessage());
        }

        // count number of overlapping points
        int overlap = 0;
        for(Point p : points.keySet()) {
            int count = points.get(p);
            if(count > 1) overlap++;
        }

        // print
        System.out.println("Total Overlapping Points: " + overlap);

        // Close the file, if possible
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Cannot close file.\n" + e.getMessage());
        }
    }


}

