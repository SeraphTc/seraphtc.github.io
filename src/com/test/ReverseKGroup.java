package com.test;

import java.util.Stack;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/10/13
 */

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode kNode = head;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        for (int i = 0; i < k - 1; i++) {
            if (kNode.next == null) {
                return head;
            }

            kNode = kNode.next;
            stack.push(kNode);
        }
        ListNode next = reverseKGroup(kNode.next, k);
        ListNode result = stack.pop();
        ListNode tail = result;
        while (!stack.isEmpty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = next;
        return result;
    }

    public static void main(String[] args) {
        ReverseKGroup s = new ReverseKGroup();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1 = s.reverseKGroup(node1, 3);
        System.out.println(node1);

    }

}
