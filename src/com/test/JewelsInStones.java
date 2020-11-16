package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/19
 */

public class JewelsInStones {

    public static void main(String[] args) {
        String J = "tuMxJ";
        String S = "LApcj";
        numJewelsInStones(J, S);
    }

    public static int numJewelsInStones(String J, String S) {
        int total = 128;
        int[] exist = new int[total];
        for (char c : J.toCharArray()) {
            int mod = (c - 'A') % total;
            exist[mod] = 1;
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            int mod = (c - 'A') % total;
            if (exist[mod] == 1) {
                count++;
            }
        }
        return count;

    }
}
