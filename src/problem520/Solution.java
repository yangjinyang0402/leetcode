package problem520;

/**
 * 520.检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * @author YangJinyang
 * @since 2024-06-23
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        // 全是小写
        if (count == 0) {
            return true;
        }
        // 全是大写
        if (count == len) {
            return true;
        }
        // 首字母是否大写
        return count == 1 && Character.isUpperCase(word.charAt(0));
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        // 输出：true
        System.out.println(new Solution().detectCapitalUse("USA"));
        // 输出：false
        System.out.println(new Solution().detectCapitalUse("FlaG"));
        // 输出：true
        System.out.println(new Solution().detectCapitalUse("ffffffffffffffffffffF"));

    }
}
