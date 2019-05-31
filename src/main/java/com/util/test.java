package com.util;

/**
 * Created by yan qing on 2019/5/22.
 */

public class test {
    public static void main(String args[]) {
        String msg = "a female, mood of speech: speaking passionately, p-value/sample size= :0.00 5";
        String[] msgSplit = msg.split(" ");
        String sex = msgSplit[2].split(".")[0];
        System.out.println(sex);
    }

}
