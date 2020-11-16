package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/30
 */

public class SpanSearch {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    public boolean search(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        if (start == end) {
            return nums[start] == target;
        }
        if (end - start == 1) {
            return nums[start] == target || nums[end] == target;
        }
        int mid = start + ((end - start) / 2);
        while (mid != start && nums[mid] == nums[start] && mid < end - 1) {
            mid++;
        }
        if (nums[mid] == target) {
            return true;
        }
        boolean leftAsc = nums[start] < nums[mid];
        if (leftAsc) {
            if (nums[mid] > target && nums[start] <= target) {
                return search(nums, start, mid, target);
            }
            return search(nums, mid + 1, end, target);
        }
        if (nums[mid] < target && nums[end] >= target) {
            return search(nums, mid + 1, end, target);
        }
        return search(nums, start, mid, target);

    }

    public static void main(String[] args) {
        SpanSearch spanSearch = new SpanSearch();
        //        System.out.println(spanSearch.search(new int[] {3,4,5,1,1,1,2}, 5));
        //        System.out.println(spanSearch.search(new int[] {3,4,5,1,1,1,2}, 6));
        System.out.println(spanSearch.search(new int[] {1, 1, 3}, 1));
        //System.out.println(spanSearch.search(new int[] {2,5,6,0,0,1,2}, 3));

    }
}
