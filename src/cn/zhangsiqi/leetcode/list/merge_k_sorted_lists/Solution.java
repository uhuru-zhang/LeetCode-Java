package cn.zhangsiqi.leetcode.list.merge_k_sorted_lists;


import java.util.LinkedList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null) {
            return "" + val;
        }

        return "" + val + ", " + next.toString();

    }
}


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        System.out.println(lists);

        List<ListNode> listsList = new LinkedList<>();
        List<Integer> listA = new LinkedList<>();

        boolean flag = true;

        for (ListNode list : lists) {
            if (list != null) {
                listsList.add(list);
            } else {
                flag = false;
            }
        }

        if (flag) {
            return null;
        }

        while (listsList.size() > 0) {
            int state = 0;
            for (int i = 0; i < listsList.size(); i++) {
                if (listsList.get(i).val < listsList.get(state).val) {
                    state = i;
                }

            }

            listA.add(listsList.get(state).val);
            listsList.set(state, listsList.get(state).next);
            if (listsList.get(state) == null) {
                listsList.remove(state);
            }
        }

        ListNode result = new ListNode(listA.get(0));

        ListNode resultNext = result;
        for (Integer node : listA.subList(1, listA.size())) {
            resultNext.next = new ListNode(node);
            resultNext = resultNext.next;
        }

        return result;
    }

    public static void main(String[] args) {

        ListNode[] lists = {
                new ListNode(1),
                new ListNode(1),
                new ListNode(2),
                new ListNode(4)
        };
        int[][] arrays = {
                {1, 4, 5, 7},
                {1, 3},
                {2, 3, 4},
                {4}
        };

        for (int i = 0; i < arrays.length; i++) {
            ListNode current = lists[i];
            for (int j = 1; j < arrays[i].length; j++) {
                current.next = new ListNode(arrays[i][j]);
                current = current.next;
            }

            System.out.println(lists[i].toString());
        }


        System.out.println(new Solution().mergeKLists(new ListNode[]{}));
    }
}