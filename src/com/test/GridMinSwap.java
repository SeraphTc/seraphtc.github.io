package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/19
 */

public class GridMinSwap {

    class Pos {
        int rowIndex;
        int zeroCount;

        public int getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public int getZeroCount() {
            return zeroCount;
        }

        public void setZeroCount(int zeroCount) {
            this.zeroCount = zeroCount;
        }

        public Pos(int rowIndex, int zeroCount) {
            this.rowIndex = rowIndex;
            this.zeroCount = zeroCount;
        }
    }

    public int minSwaps(int[][] grid) {
        List<Pos> posList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    continue;
                }
                break;
            }
            posList.add(new Pos(i, count));
        }
        posList.sort(Comparator.comparing(Pos::getZeroCount).reversed());
        if (!enough(grid.length, posList)) {
            return -1;
        }
        int count = generateCount(grid.length, posList);
        return count;
    }

    private int generateCount(int length, List<Pos> posList) {
        if(posList.isEmpty()){
            return 0;
        }
        Pos pos = posList.remove(0);
        return pos.rowIndex;
    }

    private boolean enough(int length, List<Pos> posList) {
        for (int i = length - 1; i >= 0; i--) {
            if (posList.get(0).zeroCount < i) {
                return false;
            }
            posList.remove(0);
        }
        return true;
    }
}
