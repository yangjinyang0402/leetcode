package problem1004;

/**
 * 1004.最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 *
 * @author YangJinyang
 * @since 2024-06-19
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            // rsum为数组01反转后的右指针前缀和，代表到right位置数组有几个0
            rsum += 1 - nums[right];
            // (rsum - lsum)表示left到right区间内0的个数，，若大于k，则左指针右移
            while (rsum - lsum > k) {
                // lsum为数组01反转后的左指针前缀和，代表到left位置
                // 数组有几个0
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // 输出：6
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(new Solution().longestOnes(nums1, 2));
        // 输出：10
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(new Solution().longestOnes(nums2, 3));
    }
}
