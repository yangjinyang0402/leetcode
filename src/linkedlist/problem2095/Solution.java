package linkedlist.problem2095;

/**
 * 2095.删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 * 解释：
 * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
 * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
 * 返回结果为移除节点后的新链表。
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4]
 * 输出：[1,2,4]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
 * <p>
 * 示例 3：
 * 输入：head = [2,1]
 * 输出：[2]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
 * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 *
 * @author YangJinyang
 * @since 2024-07-01
 */
public class Solution {
    /**
     * 快慢指针
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != null) {
            prev.next = slow.next;
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        // Case 1: 输入：[1,3,4,7,1,2,6] 输出：[1,3,4,1,2,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode node = new Solution().deleteMiddle(head);
        print(node);
        // Case 2: 输入：[1,2,3,4] 输出：[1,2,4]
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        node = new Solution().deleteMiddle(head);
        print(node);
        // Case 3: 输入：[2,1] 输出：[2]
        head = new ListNode(2);
        head.next = new ListNode(1);
        node = new Solution().deleteMiddle(head);
        print(node);
        // Case 4: 输入：[1] 输出：null
        head = new ListNode(1);
        node = new Solution().deleteMiddle(head);
        print(node);
    }

    private static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
