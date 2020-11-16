package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/10/13
 */

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
                continue;
            }
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l3;
        l3.next = l5;
        l2.next = l4;
        l4.next = l6;

        l1 = m.mergeTwoLists(l1,l2);
        System.out.println("12313");
    }
}
