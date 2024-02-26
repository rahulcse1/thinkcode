package com.tw.thinkcode.hackerrank;

import java.util.*;

public class IslandProblem {
    // counting island perimeter
    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int perimeter = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // count perimeter
                    perimeter += countPerimeter(grid, i, j, row, col);
                }
            }
        }
        return perimeter;
    }

    private int countPerimeter(int[][] grid, int i, int j, int row, int col) {
        int count = 0;

        if (i - 1 < 0 || grid[i - 1][j] == 0) count++;
        if (i + 1 > row || grid[i + 1][j] == 0) count++;

        if (j - 1 < 0 || grid[i][j - 1] == 0) count++;
        if (j + 1 > col || grid[i][j + 1] == 0) count++;

        return count;
    }

    // counting number of island
    public int countIsland(char[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int numberIsland = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // increase out island count
                    numberIsland++;
                    // change any other land connected to this to zero
                    changeLandToWater(grid, i, j, row, col);
                }
            }
        }
        return numberIsland;
    }

    private void changeLandToWater(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') return;
        grid[i][j] = '0';
        int[][] dirs = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        for (int k = 0; k < dirs.length; k++) {
            changeLandToWater(grid, i + dirs[k][0], j + dirs[k][1], row, col);
        }
       /*
        changeLandToWater(grid, i - 1, j, row, col);
        changeLandToWater(grid, i + 1, j, row, col);
        changeLandToWater(grid, i, j - 1, row, col);
        changeLandToWater(grid, i, j + 1, row, col);
       */
    }

    // maximum area of island

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
            return 0;
        }
        // right
        grid[i][j] = 0;
        int[][] dirs = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        int area = 0;
        for (int[] dir : dirs) {
            area += getArea(grid, i + dir[0], j + dir[1], row, col);
        }
        return area + 1;
    }

    public int numberDistinctIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Set<String> set = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;
        // X = start
        // O = out of bounds or water
        // U = Up
        // D = Down
        // R = Right
        // L = Left
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    String path = computePath(grid, i, j, row, col, "X");
                    set.add(path);
                }
            }
        }
        return set.size();
    }

    public String computePath(int[][] grid, int i, int j, int row, int col, String direction) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) return "O";
        grid[i][j] = 0;

        String left = computePath(grid, i, j - 1, row, col, "L");
        String right = computePath(grid, i, j + 1, row, col, "R");
        String up = computePath(grid, i - 1, j, row, col, "U");
        String down = computePath(grid, i + 1, j, row, col, "D");
        return direction + left + right + up + down;
    }

    List<Integer> findDuplicateInArray(int[] a) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) -1 ;
            if(a[index] < 0) result.add(index + 1);
            a[index] = -a[index];
        }
        return result;
    }

    public static void main(String[] args) {
        IslandProblem problem = new IslandProblem();
        List<Integer> result = problem.findDuplicateInArray(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7});
        System.out.println(result);
    }


}
