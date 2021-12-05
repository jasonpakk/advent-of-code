import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day4 {
    public static void main(String[] args) {
        BufferedReader input;

        // Open the file, if possible
        try {
            input = new BufferedReader(new FileReader("day4/data4.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file.\n" + e.getMessage());
            return;
        }

        String[] balls = new String[1];
        List<String[][]> grids = new ArrayList<>();
        List<boolean[][]> results = new ArrayList<>();
        List<Boolean> won = new ArrayList<>();

        // Read the file
        try {

            // first line
            String line = input.readLine();
            balls = line.split(",");

            while ((line = input.readLine()) != null) {
                try {
                    String[][] grid = new String[5][5];
                    boolean[][] result = new boolean[5][5];

                    for(int i = 0; i < 5; i++) {
                        String in = input.readLine().strip();
                        while(in.contains("  ")) {
                            in = in.replaceAll("  ", " ");
                        }
                        grid[i] = in.split(" ");

                    }
                    toStringGrid(grid);
                    grids.add(grid);
                    results.add(result);
                    won.add(false);
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

        for(int i = 0; i< balls.length; i++) {

            String currNum = balls[i];

            for(int player = 0; player < grids.size(); player++) {
                String[][] grid = grids.get(player);

                for(int r = 0; r < 5; r++) {
                    for(int c = 0; c < 5; c++) {

                        if(currNum.equals(grid[r][c])) {
                            results.get(player)[r][c] = true;
                            if(!won.get(player) && compute(results.get(player))) {
                                System.out.println("player : " + player);
                                System.out.println("last num: " + currNum);
                                finalResult(grid, results.get(player), currNum);
                                won.set(player, true);
                            }
                        }

                    }
                }
            }
        }
    }

    private static void finalResult(String[][] grid1, boolean[][] grid2, String lastnum) {
        toStringGrid(grid1);
        int sum = 0;
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                if(!grid2[r][c]) sum += Integer.parseInt(grid1[r][c]);
            }
        }

        System.out.println("SCORE: " + sum * Integer.parseInt(lastnum) );
        System.out.println();
    }

    private static void toStringGrid(String[][] grid) {
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void toStringGrid2(boolean[][] grid) {
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean compute(boolean[][] grid) {

        // rows
        for(int r = 0; r < 5; r++) {
            boolean row = true;
            for(int c = 0; c < 5; c++) {
                if(grid[r][c] == false) row = false;
            }

            if(row == true) {
                return true;
            }
        }

        // column
        for(int c = 0; c < 5; c++) {
            boolean column = true;
            for(int r = 0; r < 5; r++) {
                if(grid[r][c] == false) column = false;
            }

            if(column == true) {
                return true;
            }
        }

        // diagonal
        boolean diagonal = true;
        for(int x = 0; x < 5; x++) {
            if(grid[x][x] == false) diagonal = false;
        }
        if(diagonal == true) {
            return true;
        }

        return false;
    }

}

