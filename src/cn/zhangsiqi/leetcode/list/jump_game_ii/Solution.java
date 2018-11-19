package cn.zhangsiqi.leetcode.list.jump_game_ii;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {

            return 0;
        }

        int step_num = 0;
        int current_index = 0;
        while (current_index < nums.length) {
            if (current_index + nums[current_index] >= nums.length - 1) {
                step_num += 1;
                break;
            }
            int max = nums[current_index];
            int next_index = current_index;

            for (int i = 1; i <= nums[current_index] && current_index + i < nums.length; i++) {
                if (max < i + nums[current_index + i]) {
                    max = i + nums[current_index + i];
                    next_index = current_index + i;
                }
            }

            step_num += 1;
            current_index = next_index;
        }

        return step_num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 1, 3, 1, 1, 4}));
    }
}
