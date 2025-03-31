/*
 * @lc app=leetcode.cn id=876 lang=java
 * @lcpr version=30104
 *
 * [876] 链表的中间结点
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MiddleOfTheLinkedList {

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
        public ListNode middleNode(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            return p1;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5,6]\n
 * // @lcpr case=end
 * 
 */
