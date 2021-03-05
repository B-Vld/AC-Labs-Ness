package com.ness;

import java.util.Arrays;


public class Maze {

    /*
        I did this so I can visualize the matrix better
     */
    public static final char WALL = '0';
    public static final char ROAD = '1';
    public static final char KATE = 'k';

    private final char[][] matrixMaze;
    private Coordinate start;
    private boolean moreThanOneKate;
    private final boolean[][] visited;

    public Maze(String[] maze) {
        /*
            max -> getting the max length of a String in String[] maze
                   in order to remove annoying edge cases where the
                   Strings in String[] maze come in different lengths
         */
        int max = Arrays.
                stream(maze).
                map(String::length).
                max(Integer::compareTo).
                get();

        int kateCounter = 0;
        matrixMaze = new char[maze.length][max];
        int row = 0, col = 0;
        visited = new boolean[maze.length][max];


        /*
            "Parsing" String[] maze to char[][] maze
         */
        for (String s : maze) {
            char[] line = s.toCharArray();
            for (int j = 0; j < max; ++j) {
                try {
                    if (line[j] == '#') {
                        this.matrixMaze[row][col] = WALL;
                    }
                    if (line[j] == ' ') {
                        this.matrixMaze[row][col] = ROAD;
                    }
                    if (line[j] == 'k') {
                        kateCounter++;
                        if (kateCounter > 1)
                            moreThanOneKate = true;
                        else {
                            this.matrixMaze[row][col] = KATE;
                            start = new Coordinate(row, col);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    /*
                        If there are different length Strings in String[] maze
                        Example :
                                    String a="######"
                                    String b="##k "

                        String a has 2 more chars compared to String b

                        The missing chars in String b should be of type ROAD (' ')
                     */
                    this.matrixMaze[row][col] = ROAD;
                }
                col++;
            }
            col = 0;
            row++;
        }
    }

    /*
     * Helpers
     * Setters
     * Getters
     * Bounds Checking
     */

    public boolean isValidLocation(int row, int col) {
        return row >= 0 && row < getHeight() && col >= 0 && col < getWidth();
    }

    public boolean isExit(int x, int y) {
        return checkBounds(x, y);
    }

    public boolean checkBounds(int x, int y) {
        if (x == 0 && (matrixMaze[x][y] == '1' || matrixMaze[x][y] == 'k'))
            return true;
        if (y == 0 && (matrixMaze[x][y] == '1' || matrixMaze[x][y] == 'k'))
            return true;
        if (x == getHeight() - 1 && ((matrixMaze[x][y] == '1' || matrixMaze[x][y] == 'k')))
            return true;
        return y == getWidth() - 1 && ((matrixMaze[x][y] == '1' || matrixMaze[x][y] == 'k'));
    }

    public boolean isWall(int row, int col) {
        return matrixMaze[row][col] == WALL;
    }

    public void setVisited(int row, int col, boolean value) {
        visited[row][col] = value;
    }

    public boolean isExplored(int row, int col) {
        return visited[row][col];
    }

    public int getHeight() {
        return matrixMaze.length;
    }

    public int getWidth() {
        return matrixMaze[0].length;
    }

    public Coordinate getStart() {
        return start;
    }

    public boolean getMoreThanOneKate() {
        return moreThanOneKate;
    }

}
