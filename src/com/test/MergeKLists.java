package com.test;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/29
 */

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (end - start == 1) {
            return merge2(lists[start], lists[end]);
        }
        int mid = start + ((end - start) / 2);
        return merge2(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    private ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode resultHead = list1.val <= list2.val ? list1 : list2;
        if(resultHead == list1){
            list1 = list1.next;
        }
        if(resultHead == list2){
            list2 = list2.next;
        }

        ListNode result = resultHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = list1;
                result = result.next;
                list1 = list1.next;
            }else{
                result.next = list2;
                result = result.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            result.next = list1;
        }
        if(list2 != null){
            result.next = list2;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        MergeKLists k = new MergeKLists();
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode[] list = new ListNode[]{node1,node2,node3,node4,node5,node6};
        node1 = k.mergeKLists(list);
        System.out.println(1111);


    }


}
