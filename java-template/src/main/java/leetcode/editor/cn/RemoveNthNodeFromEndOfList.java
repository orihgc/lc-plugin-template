/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30104
 *
 * [19] 删除链表的倒数第 N 个结点
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int count = 0;
            ListNode res=head;
            ListNode p = head;
            while (head != null) {
                if (++count > n+1) {
                    p = p.next;
                }
                head = head.next;
            }
            p.next=p.next.next;
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n1\n
 * // @lcpr case=end
 * 
 */
