package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/29
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        String example = strs[0];
        for (int i = 0; i < example.length(); i++) {
            char c = example.charAt(i);
            Boolean needBreak = false;
            for (int j = 1; j < strs.length; j++) {

                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    needBreak = true;
                    break;
                }
            }
            if (needBreak) {
                break;
            }
            result += c;
        }
        return result;
    }
}
