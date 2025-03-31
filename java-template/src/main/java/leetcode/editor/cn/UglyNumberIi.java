/*
 * @lc app=leetcode.cn id=264 lang=java
 * @lcpr version=30104
 *
 * [264] 丑数 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class UglyNumberIi {

    // @lc code=start
    class Solution {
        public int nthUglyNumber(int n) {
            // 可以理解为三个指向有序链表头结点的指针
            int p2 = 1, p3 = 1, p5 = 1;
            // 可以理解为三个有序链表的头节点的值
            int product2 = 1, product3 = 1, product5 = 1;
            // 可以理解为最终合并的有序链表（结果链表）
            int[] ugly = new int[n + 1];
            // 可以理解为结果链表上的指针
            int p = 1;
    
            // 开始合并三个有序链表
            while (p <= n) {
                // 取三个链表的最小结点
                int min = Math.min(Math.min(product2, product3), product5);
                // 接到结果链表上
                ugly[p] = min;
                p++;
                // 前进对应有序链表上的指针
                if (min == product2) {
                    product2 = 2 * ugly[p2];
                    p2++;
                }
                if (min == product3) {
                    product3 = 3 * ugly[p3];
                    p3++;
                }
                if (min == product5) {
                    product5 = 5 * ugly[p5];
                    p5++;
                }
            }
            // 返回第 n 个丑数
            return ugly[n];
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        // put your test code here
        solution.nthUglyNumber(10);
    }
}

/*
 * // @lcpr case=start
 * // 10\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */
