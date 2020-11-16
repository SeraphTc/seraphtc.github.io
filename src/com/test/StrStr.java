package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/10/13
 */

public class StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int targetLength = needle.length();
        int matchCount = 0;
        for (int i = 0; i < source.length - target.length + 1; i++) {
            if (source[i] != target[0]) {
                continue;
            }
            matchCount++;
            while (matchCount < targetLength && source[i + matchCount] == target[matchCount]) {
                matchCount++;
            }
            if (matchCount == targetLength) {
                return i;
            }
            matchCount = 0;
        }
        return -1;
    }

    public static void main(String[] args) {

        StrStr s = new StrStr();
        int index = s.strStr("mississippi", "sipp");
        System.out.println(index);
    }
}
