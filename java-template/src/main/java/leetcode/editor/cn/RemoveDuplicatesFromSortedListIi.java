/*
 * @lc app=leetcode.cn id=82 lang=java
 * @lcpr version=30104
 *
 * [82] 删除排序链表中的重复元素 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedListIi {

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dump1 = new ListNode(1001);
            ListNode dump2 = new ListNode(1001);
            ListNode p1 = dump1;
            ListNode p2 = dump2;
            ListNode p = head;
            while (p != null) {
                if ((p.next != null && p.val == p.next.val) || p.val == p2.val) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }
            return dump1.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[] { -1,0,0,0,0,3,3 });
        ListNode res = solution.deleteDuplicates(head);
        ListNode.print(res);

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,3,4,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,1,2,3]\n
 * // @lcpr case=end
 * 
 */
