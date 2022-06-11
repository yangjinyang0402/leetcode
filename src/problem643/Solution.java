package problem643;

/**
 * 643. 子数组最大平均数 I
 *
 * @author Jinyang
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        // 计算初始滑动窗口
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // 滑动窗口移动
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum * 1.0 / k;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        double maxAverage1 = findMaxAverage(nums1, 4);
        assert Double.compare(maxAverage1, 12.75) == 0 : "The test case failed: nums = [1,12,-5,-6,50,3], k = 4";

        // 测试用例3
        int[] nums2 = {5};
        double maxAverage2 = findMaxAverage(nums2, 1);
        assert Double.compare(maxAverage2, 5.000) == 0 : "The test case failed: nums = [5], k = 1";

        // 测试用例3
        int[] nums3 = {0, 4, 0, 3, 2};
        double maxAverage3 = findMaxAverage(nums3, 1);
        assert Double.compare(maxAverage3, 4.0) == 0 : "The test case failed: nums = [0, 4, 0, 3, 2], k = 1";
    }
}
