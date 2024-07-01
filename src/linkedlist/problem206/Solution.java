package linkedlist.problem206;

/**
 * 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * @author YangJinyang
 * @since 2024-07-01
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
        // Case 1: 输入：1->2->3->4->5->NULL，输出：5->4->3->2->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        print(new Solution().reverseList(head));

        // Case 2: 输入：1->2->NULL，输出：2->1->NULL
        head = new ListNode(1);
        head.next = new ListNode(2);
        print(new Solution().reverseList(head));

        // Case 3: 输入：NULL，输出：NULL
        print(new Solution().reverseList(null));
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
