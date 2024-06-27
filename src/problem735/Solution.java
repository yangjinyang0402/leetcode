package problem735;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 735.小行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 * <p>
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 * 示例 2：
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * <p>
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * 提示：
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * @author YangJinyang
 * @since 2024-06-27
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isAlive = true;
            while (isAlive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                isAlive = stack.peek() < -asteroid;
                if (stack.peek() <= -asteroid) {
                    stack.pop();
                }
            }
            if (isAlive) {
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        // 输出：[5,10]
        int[] asteroids = new int[]{5, 10, -5};
        System.out.println(Arrays.toString(new Solution().asteroidCollision(asteroids)));
        // 输出：[]
        asteroids = new int[]{8, -8};
        System.out.println(Arrays.toString(new Solution().asteroidCollision(asteroids)));
        // 输出：[10]
        asteroids = new int[]{10, 2, -5};
        System.out.println(Arrays.toString(new Solution().asteroidCollision(asteroids)));
        // 输出：[-2, -1, 1, 2]
        asteroids = new int[]{-2, -1, 1, 2};
        System.out.println(Arrays.toString(new Solution().asteroidCollision(asteroids)));
    }
}
