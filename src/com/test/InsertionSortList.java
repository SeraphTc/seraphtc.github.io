package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/29
 */

public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            result = insert(result, tmp);
        }
        return result;
    }

    private static ListNode insert(ListNode result, ListNode tmp) {
        if (result == null) {
            tmp.next = null;
            result = tmp;
            return result;
        }

        ListNode node = result;
        ListNode pre = null;

        while (node != null && node.val <= tmp.val) {
            pre = node;
            node = node.next;
        }
        if(node == null){
            pre.next = tmp;
            tmp.next = null;
            return result;
        }
        if(pre == null){
            tmp.next = result;
            return tmp;
        }
        pre.next = tmp;
        tmp.next = node;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1 = insertionSortList(node1);
        System.out.println(1L);
    }


}
