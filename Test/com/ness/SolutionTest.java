package com.ness;

/*
    I don't really know how to do testing
    I tried xD
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void hasExit() {
        String[] one = new String[]{
                "k"
        };
        String[] two = new String[]{
                "###",
                "#k#",
                "###"
        };
        String[] three = new String[] {
                "###",
                "#k ",
                "###"
        };
        String[] four = new String[] {  "k ",
                "kk"
        };
        String[] five = new String[]{
                "########",
                "# # ####",
                "# #k#   ",
                "# # # ##",
                "# # # ##",
                "#      #",
                "########"
        };
        String[] six= new String[]{
                "########",
                "# # ## #",
                "# #k#  #",
                "# # # ##",
                "# # #  #",
                "#     ##",
                "########"
        };

        assertEquals(true,Solution.hasExit(one));
        assertEquals(false,Solution.hasExit(two));
        assertEquals(true,Solution.hasExit(three));
        assertEquals(false,Solution.hasExit(four));
        assertEquals(true,Solution.hasExit(five));
        assertEquals(false,Solution.hasExit(six));
    }
}