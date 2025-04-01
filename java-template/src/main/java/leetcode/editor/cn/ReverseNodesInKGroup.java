/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30104
 *
 * [25] K 个一组翻转链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseNodesInKGroup {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                if (b == null) {
                    return head;
                }
                b = b.next;
            }

            ListNode newHead = reverseN(a, k);
            a.next = reverseKGroup(b, k);
            return newHead;
        }

        ListNode successor = null;

        private ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here
        solution.reverseKGroup(ListNode.createHead(new int[] { 1, 2, 3, 4, 5 }), 2);

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n3\n
 * // @lcpr case=end
 * 
 */
