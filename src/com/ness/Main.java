package com.ness;

public class Main {

    public static void main(String[] args) {

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
        System.out.println(Solution.hasExit(one));
        System.out.println(Solution.hasExit(two));
        System.out.println(Solution.hasExit(three));
        System.out.println(Solution.hasExit(four));
        System.out.println(Solution.hasExit(five));
        System.out.println(Solution.hasExit(six));

    }
}
