package com.ness;


/*
    The purpose of this class is to get the coordinates
    [x][y] -> [row][col] of every character (if needed)
    in matrix maze
 */
public class Coordinate {
    int x;
    int y;
    Coordinate parent;

    public int getY() {
        return y;
    }

    public int getX() {
        return this.x;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    public Coordinate(int x, int y, Coordinate parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
}
