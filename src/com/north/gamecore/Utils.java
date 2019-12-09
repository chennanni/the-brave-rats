package com.north.gamecore;

public class Utils {

    public static int parseInput(String input) {
        int num = -1;
        try {
            num = Integer.valueOf(input);
        } catch(Exception e) {
            num = 99;
        }
        return num;
    }

    public static void sleep(int second) {
        try {
            for (int i=0; i<second; i++){
                Thread.sleep(1000);
                System.out.println("...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
