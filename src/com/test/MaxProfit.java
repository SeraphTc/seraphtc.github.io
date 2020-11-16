package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/29
 */

public class MaxProfit {


    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int low = prices[0];
        int high = prices[0];
        int highIndex = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                max = max > high - low ? max : high - low;
                low = prices[i];
                high = low;
                highIndex = i;
                continue;
            }
            if (prices[i] > high) {
                high = prices[i];
                highIndex = i;
                max = max > high - low ? max : high - low;
            }

        }

        return max > 0 ? highIndex + 1 : 0;

    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2};
        System.out.println(maxProfit(input));
    }
}
