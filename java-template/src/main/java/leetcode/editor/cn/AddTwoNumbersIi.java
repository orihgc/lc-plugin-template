/*
 * @lc app=leetcode.cn id=445 lang=java
 * @lcpr version=30104
 *
 * [445] 两数相加 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class AddTwoNumbersIi {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                    // 把链表元素转入栈中
        Stack<Integer> stk1 = new Stack<>();
        while (l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stk2 = new Stack<>();
        while (l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }

        // 接下来基本上是复用我在第 2 题的代码逻辑
        // 注意新节点要直接插入到 dummy 后面

        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);

        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (!stk1.isEmpty() || !stk2.isEmpty() || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (!stk1.isEmpty()) {
                val += stk1.pop();
            }
            if (!stk2.isEmpty()) {
                val += stk2.pop();
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点，直接接在 dummy 后面
            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [7,2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

 */

