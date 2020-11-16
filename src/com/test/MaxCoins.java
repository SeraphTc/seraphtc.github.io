package com.test;

import java.util.Arrays;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/19
 */

public class MaxCoins {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int max = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            max += piles[piles.length / 3 + i * 2];
        }
        return max;
    }
}
