package cn.zhangsiqi.leetcode.list.first_missing_positive;

class Solution {

    /**
     * https://leetcode-cn.com/problems/first-missing-positive/description/
     * 首先，一个长度为 n 的数组如果满足 nums[i] = i + 1 的情况下(即数组数据为 1，2，...，n)
     * 那么这个数组的起一个缺失数字就为 n + 1 ，否则一定比 n 小。所以数组内的大于n和小于1的数据时不影响运算结果的。
     */
    public int firstMissingPositive(int[] nums) {
        /*
         * 根据以上描述，我们数组遍历一遍，然后将所有不在 1 到 n 范围内的数据都变为 -1。
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = -1;
            }
        }

        /*
         * 之后我们把 数组内的 不等于 -1 的元素 tmp 放在 tmp - 1 的位置。
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] != -1) {
                int tmp = nums[i];
                /*
                 * 如果 tmp - 1 位置已经存在 tmp 那我们将 当前遍历的位置元素设置为 -1
                 */
                if (nums[tmp - 1] == tmp) {
                    nums[i] = -1;
                } else {
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                    i --;
                }

            }
        }

        /*
         * 选取第一个是 -1 的元素的位置，那么该位置本来的元素就是 第一个缺失的最小正数。
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1, 1}));
    }
}