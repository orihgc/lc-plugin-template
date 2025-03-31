/*
 * @lc app=leetcode.cn id=86 lang=java
 * @lcpr version=30104
 *
 * [86] 分隔链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            ListNode dump1 = new ListNode(-1), p1 = dump1;
            ListNode dump2 = new ListNode(-1), p2 = dump2;
            while (head != null) {
                if (head.val < x) {
                    p1.next = head;
                    p1 = p1.next;
                } else {
                    p2.next = head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p2.next = null;
            p1.next = dump2.next;
            return dump1.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[] { 1, 4, 3, 2, 5, 2 });
        ListNode res = solution.partition(head, 3);
        ListNode.print(res);
    }
}

/*
 * // @lcpr case=start
 * // [1,4,3,2,5,2]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,1]\n2\n
 * // @lcpr case=end
 * 
 */
