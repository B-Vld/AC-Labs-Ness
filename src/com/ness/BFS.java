package com.ness;

import java.util.LinkedList;


public class BFS {

    /*
        Kate directions
     */
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /*
        BFS iterative approach
     */
    public boolean solve(Maze maze) {
        /*
            Probably should have used a Queue or Stack
         */
        LinkedList<Coordinate> nextToVisit = new LinkedList<>();
        Coordinate start = maze.getStart();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            /*
                Checks if the current coordinate is either a "valid location" / a "wall" / an "exit"
             */
            Coordinate cur = nextToVisit.remove();

            if (!maze.isValidLocation(cur.getX(), cur.getY()) || maze.isExplored(cur.getX(), cur.getY())) {
                continue;
            }

            if (maze.isWall(cur.getX(), cur.getY())) {
                maze.setVisited(cur.getX(), cur.getY(), true);
                continue;
            }

            if (maze.isExit(cur.getX(), cur.getY())) {
                return true;
            }
            /*

                Starts at Kate's position and checks for up,down,left,right
                Adds all the potential positions to the list

             */
            for (int[] direction : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                maze.setVisited(cur.getX(), cur.getY(), true);
            }
        }
        return false;
    }

}
