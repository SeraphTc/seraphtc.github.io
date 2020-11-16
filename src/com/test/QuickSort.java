package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/10/15
 */

public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = getIndex(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);

    }

    private int getIndex(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tmp) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
