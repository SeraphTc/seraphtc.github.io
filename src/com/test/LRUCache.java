package com.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class LRUCache {

    int size;


    Map<Integer, DoubleListNode> map = new ConcurrentHashMap<>();


    DoubleListNode tail = null;

    DoubleListNode head = null;

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleListNode node = map.get(key);
        if (size == 1 || node == head) {
            return node.val;
        }

        DoubleListNode pre = node.pre;
        DoubleListNode next = node.next;
        DoubleListNode headPre = head;

        if(pre == null){
            tail = next;
        }else{
            pre.next = next;
        }
        headPre.next = node;
        head = node;
        node.pre = headPre;
        node.next = null;
        next.pre = pre;
        return node.val;
    }




    public void put(int key, int value) {

        if (size == 1) {
            map.clear();
            map.put(key, new DoubleListNode(key, value));
            return;
        }

        if(this.get(key) != -1){
            map.get(key).val = value;
            return;
        }

        if (map.size() >= size) {
            DoubleListNode least = tail;
            tail = tail.next;
            least.next.pre = null;
            map.remove(least.key);
        }

        DoubleListNode node = new DoubleListNode(key, value);
        if (map.size() == 0) {
            head = node;
            tail = node;
        } else {
            DoubleListNode pre = head;
            pre.next = node;
            node.pre = pre;
            node.next = null;
            head = node;
            map.put(pre.key, pre);
        }
        map.put(key, node);
        return;
    }

    class DoubleListNode {
        int val;
        int key;
        DoubleListNode next;
        DoubleListNode pre;

        DoubleListNode(int k, int v) {
            val = v;
            key = k;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);
        obj.get(2);
        obj.put(4, 4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }

}