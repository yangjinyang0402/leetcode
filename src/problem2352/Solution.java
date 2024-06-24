package problem2352;

import java.util.*;

/**
 * 2352.相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * 示例 1：
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * <p>
 * 示例 2：
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * 提示：
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 *
 * @author YangJinyang
 * @since 2024-06-24
 */
public class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int num : row) {
                list.add(num);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        int ans = 0;
        int n = grid.length;
        for (int j = 0; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int[] nums : grid) {
                list.add(nums[j]);
            }
            if (map.containsKey(list)) {
                ans += map.get(list);
            }
        }
        return ans;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(new Solution().equalPairs(grid));

        grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(new Solution().equalPairs(grid));

        grid = new int[][]{{11, 1}, {1, 11}};
        System.out.println(new Solution().equalPairs(grid));
    }
}
