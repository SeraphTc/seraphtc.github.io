package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/10/13
 */

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode tmp = head;
            head = head.next;
            head.next = tmp;
            tmp.next = null;
            return head;
        }
        ListNode tmp = head;
        ListNode next = swapPairs(tmp.next.next);
        head = head.next;
        head.next = tmp;
        tmp.next = next;
        return head;
    }

    public static void main(String[] args) {
        SwapPairs s = new SwapPairs();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1 = s.swapPairs(node1);
        System.out.println(node1);

    }
}
