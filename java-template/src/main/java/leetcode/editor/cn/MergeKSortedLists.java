/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30104
 *
 * [23] 合并 K 个升序链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;
            // 虚拟头结点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            // 优先级队列，最小堆
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    lists.length, (a, b) -> (a.val - b.val));
            // 将 k 个链表的头结点加入最小堆
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head);
                }
            }

            while (!pq.isEmpty()) {
                // 获取最小节点，接到结果链表中
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }
                // p 指针不断前进
                p = p.next;
            }
            return dummy.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [[1,4,5],[1,3,4],[2,6]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[]]\n
 * // @lcpr case=end
 * 
 */
