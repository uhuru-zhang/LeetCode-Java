package cn.zhangsiqi.leetcode.list;

import java.util.Random;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNodes(int n) {
        Random r = new Random();
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i : r.ints(n, 0, 100).toArray()) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return head;
    }

    @Override
    public String toString() {
        if (next == null) {
            return "" + val;
        }

        return "" + val + ", " + next.toString();

    }
}
