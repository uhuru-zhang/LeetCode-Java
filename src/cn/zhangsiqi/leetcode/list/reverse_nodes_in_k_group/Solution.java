package cn.zhangsiqi.leetcode.list.reverse_nodes_in_k_group;

import cn.zhangsiqi.leetcode.list.ListNode;

public class Solution {
    /**
     * 我们记录每一个列表的位置，很明显，在已知位置的情况下，每个元素的变换之后的位置是确定的
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current_node = head;
        int count = 0;
        while (current_node != null && count != k) {
            current_node = current_node.next;
            count++;
        }
        if (count == k) {
            current_node = reverseKGroup(current_node, k);/// 递归的解决子问题
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current_node;
                current_node = head;
                head = temp;
            }///最终，该段的所有节点将会截空，head应指向current_node
            head = current_node;
        }
        return head;
    }
}