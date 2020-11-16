package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/19
 */

public class FindMaxSubstring {

    public static void main(String[] args) {
        String s = "absdsdffasd";
        Map<Character, Integer> positionMap = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (positionMap.containsKey(c) && positionMap.get(c) >= start) {
                int tempResult = i - start;
                max = max > tempResult ? max : tempResult;
                start = positionMap.get(c) + 1;
            }
            positionMap.put(s.charAt(i), i);
        }
        max = max > s.length() - start ? max : s.length() - start;
        System.out.println(max);
    }
}
