package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/19
 */

public class NumMagicSquaresInside {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        partition(node1, 3);

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode bigHead = null;
        ListNode bigTail = null;
        ListNode smallHead = null;
        ListNode smallTail = null;

        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            if (tmp.val >= x) {
                if (bigHead == null) {
                    bigHead = tmp;
                } else {
                    bigTail.next = tmp;
                }
                bigTail = tmp;
                bigTail.next = null;
            } else {
                if (smallHead == null) {
                    smallHead = tmp;
                }
                if(smallTail != null){
                    smallTail.next = tmp;
                }
                smallTail = tmp;
                smallTail.next = null;
            }
        }
        if (smallHead == null) {
            return bigHead;
        }
        if (bigHead == null) {
            return smallHead;
        }
        smallTail.next = bigHead;
        return smallHead;
    }
}

