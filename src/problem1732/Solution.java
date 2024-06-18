package problem1732;

/**
 * 1732. 找到最高海拔
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * <p>
 * 示例 1：
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * <p>
 * 示例 2：
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 * <p>
 * 提示：
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 *
 * @author Jinyang
 * @since 2024-06-18
 */
public class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for (int x : gain) {
            // 当前海拔高度
            current = x + current;
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        // 输出：1。海拔高度依次为[0,-5,-4,1,1,-6]，最高海拔为1。
        Solution solution = new Solution();
        int[] gains1 = {-5, 1, 5, 0, -7};
        System.out.println(solution.largestAltitude(gains1));
        // 输出：0。海拔高度依次为[0,-4,-7,-9,-10,-6,-3,-1]，最高海拔为0。
        int[] gains2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(solution.largestAltitude(gains2));
    }
}
