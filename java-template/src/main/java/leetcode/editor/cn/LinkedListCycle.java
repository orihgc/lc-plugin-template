/*
 * @lc app=leetcode.cn id=141 lang=java
 * @lcpr version=30104
 *
 * [141] 环形链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LinkedListCycle {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
                if (p1 == p2) {
                    return true;
                }
            }
            return false;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [3,2,0,-4]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n-1\n
 * // @lcpr case=end
 * 
 */
