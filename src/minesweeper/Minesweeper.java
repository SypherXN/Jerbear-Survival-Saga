package minesweeper;

import java.util.Scanner;

import adventure.Main;
import adventure.command.CmdMine;

/**
 * Standalone Minesweeper
 *
 */
public class Minesweeper {
    
    private static final int WIDTH = 9, HEIGHT = 9, BOMBS = 10;

    public static void play() {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[WIDTH][HEIGHT];
        boolean[][] mask = new boolean[WIDTH][HEIGHT]; // Note to self: true means hidden
        boolean[][] win = new boolean[WIDTH][HEIGHT];
        for (int x=0; x < WIDTH; x++) {
            for (int y=0; y < HEIGHT; y++) {
                grid[x][y] = 0;
            }
        }
        for (int i=0; i < BOMBS; i++) {
            int x = Main.rand.nextInt(WIDTH), y = Main.rand.nextInt(HEIGHT);
            if (grid[x][y] == -1) {
                i -= 1;
                win[x][y] = true;
            } else {
                grid[x][y] = -1;
                for (int sx=x-1; sx <= x+1; sx++) {
                    for (int sy=y-1; sy <= y+1; sy++) {
                        try {
                            if (!((sx == x && sy == y) || grid[sx][sy] == -1)) {
                                grid[sx][sy] += 1;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }
        for (int x=0; x < WIDTH; x++) {
            for (int y=0; y < HEIGHT; y++) {
                mask[x][y] = true;
            }
        }
        while (true) {
            System.out.println(renderMinesweeperGrid(grid, mask));
            int x, y, val;
            while (true) {
                try {
                    String[] input = sc.nextLine().split(" ");
                    x = Integer.parseInt(input[0]);
                    y = Integer.parseInt(input[1]);
                    val = grid[x][y];
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }
            if (val == -1) {
                System.out.println(renderMinesweeperGrid(grid, new boolean[WIDTH][HEIGHT]));
                System.out.println("You lose!");
                break;
            } else if (val == 0) {
                int[][] floatingGrid = copyGrid(grid);
                minesweepfloodfill(x, y, 0, 1337, floatingGrid);
                for (int fx=0; fx < WIDTH; fx++) {
                    for (int fy=0; fy < HEIGHT; fy++) {
                        if (floatingGrid[fx][fy] == 1337) {
                            mask[fx][fy] = false;
                        }
                    }
                }
            } else {
                mask[x][y] = false;
            }
            if (mask.equals(win)) {
                System.out.println("You win!");
            }
        }
        sc.close();
    }
    
    public static void minesweepfloodfill(int x, int y, int old, int replace, int[][] grid) {
        try {
            boolean isOld = grid[x][y] == old;
            grid[x][y] = replace;
            if (isOld) {
                minesweepfloodfill(x-1, y,   old, replace, grid);
                minesweepfloodfill(x,   y-1, old, replace, grid);
                minesweepfloodfill(x+1, y,   old, replace, grid);
                minesweepfloodfill(x,   y+1, old, replace, grid);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }
    
    public static int[][] copyGrid(int[][] original) {
        int width = original.length, height = original[0].length;
        int[][] newGrid = new int[width][height];
        for (int x=0; x < width; x++) {
            for (int y=0; y < height; y++) {
                newGrid[x][y] = original[x][y];
            }
        }
        return newGrid;
    }
    
    public static String renderMinesweeperGrid(int[][] grid, boolean[][] mask) {
        String s = " x ";
        for (int i=0; i < WIDTH; i++) {
            s += String.valueOf(i) + " ";
        }
        s += "\ny+-";
        for (int i=0; i < WIDTH - 1; i++) {
            s += "--";
        }
        s += "-\n";
        for (int y=0; y < HEIGHT; y++) {
            s += String.valueOf(y) + "| ";
            for (int x=0; x < WIDTH; x++) {
                String cell = "";
                int cellval = grid[x][y];
                if (mask[x][y]) {
                    cell = "?";
                } else if (cellval == -1) {
                    cell = "#";
                } else if (cellval == 0){
                    cell = ".";
                } else {
                    cell = String.valueOf(cellval);
                }
                s += cell + " ";
            }
            s += "\n";
        }
        return s;
    }
    
    public static void main(String[] args) {
        new CmdMine().onCalled(null, null, "minesweeper");
    }
    
}
