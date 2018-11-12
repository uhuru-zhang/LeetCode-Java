package cn.zhangsiqi.leetcode.list.trapping_rain_water;

public class Solution {
    /**
     * 首先找到最高的位置，之后从数组的两侧向最高位置遍历。
     */
    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int current_height = 0;
        int current_water = 0;
        int water = 0;

        int max = 0;
        int max_index = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                max_index = i;
            }
        }


        for (int i = 0; i <= max_index; i++) {
            if (current_height <= height[i]) {
                current_height = height[i];
                water += current_water;
                current_water = 0;
            } else {
                current_water += current_height - height[i];
            }
        }


        current_height = 0;
        current_water = 0;
        for (int i = height.length - 1; i >= max_index; i--) {
            if (current_height <= height[i]) {
                current_height = height[i];
                water += current_water;
                current_water = 0;
            } else {
                current_water += current_height - height[i];
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
