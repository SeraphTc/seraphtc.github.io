package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/30
 */

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x >= 10 && x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (x / 10 > reverse) {
            reverse *= 10;
            reverse += (x % 10);
            x = x / 10;
        }

        return x == reverse || (x / 10) == reverse;
    }

    public static void main(String[] args) {
        IsPalindrome p = new IsPalindrome();
        System.out.println(p.isPalindrome(21120));
    }

}
