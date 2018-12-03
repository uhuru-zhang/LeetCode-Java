package cn.zhangsiqi.leetcode.list.insert_interval;

import cn.zhangsiqi.leetcode.list.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int left = 0;
        int right = intervals.size() - 1;

        /*
        首先判断特殊情况，有三种特殊情况
        1. intervals 长度为 0
        2. newInterval 的 左值 比 intervals 最后一个元素的右值大
        3. newInterval 的 右值 比 intervals 的第一个元素的左值小
         */
        if (intervals.size() == 0) {
            return Collections.singletonList(newInterval);
        }


        if (intervals.get(0).start > newInterval.end) {
            intervals.add(0, newInterval);
            return intervals;
        }

        if (intervals.get(intervals.size() - 1).end < newInterval.start) {
            intervals.add(newInterval);
            return intervals;
        }


        /*
        从左向右遍历数组，找到第一个这样的元素，他的右值大于等于 newInterval 的左值。
         */
        for (int i = 0; i < intervals.size(); i++) {
            left = i;
            if (intervals.get(i).end >= newInterval.start) {
                break;
            }
        }

        /*
        从右向左遍历数组，找到第一个这样的元素，他的左值大=小于等于 newInterval 的右值。
         */
        for (int i = intervals.size() - 1; i >= 0; i--) {
            right = i;
            if (intervals.get(i).start <= newInterval.end) {
                break;
            }
        }

        /*
        选取新构成的 interval 的左值和右值
         */
        int min = newInterval.start < intervals.get(left).start ? newInterval.start : intervals.get(left).start;
        int max = newInterval.end > intervals.get(right).end ? newInterval.end : intervals.get(right).end;

        /*
        删除原数组中 left 和 right 之间的所有元素
         */
        for (int i = left; i < right + 1; i++) {
            intervals.remove(left);
        }

        /*
        将新元素插入
         */
        intervals.add(left, new Interval(min, max));

        return intervals;
    }

    public static void main(String[] args) {
        // [1,2],[3,5],[6,7],[8,10],[12,16]
        int[][] intervalsAarry = new int[][]{
//                {1, 2},
//                {3, 5},
//                {6, 7},
//                {8, 10},
//                {12, 16}
                {1, 3},
                {6, 9}
        };

        List<Interval> intervals = new ArrayList<>();
        for (int[] interval : intervalsAarry) {
            intervals.add(new Interval(interval[0], interval[1]));
        }

//        Interval newInterval = new Interval(4, 8);
        Interval newInterval = new Interval(2, 5);

        Solution solution = new Solution();
        List<Interval> result = solution.insert(intervals, newInterval);
        System.out.println(result);
    }
}