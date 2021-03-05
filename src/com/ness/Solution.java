package com.ness;

public class Solution {

    public static boolean hasExit(String[] maze) {
        Maze m = new Maze(maze);
        boolean b = treatKateException(m);
        if (b)
            return false;
        else {
            return new BFS().solve(m);
        }
    }

    private static boolean treatKateException(Maze m) {
        try {
            boolean kate = m.getMoreThanOneKate();
            if (kate)
                throw new RuntimeException("There should be no multiple Kate's");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

}
