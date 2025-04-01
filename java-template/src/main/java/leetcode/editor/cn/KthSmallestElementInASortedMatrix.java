/*
 * @lc app=leetcode.cn id=378 lang=java
 * @lcpr version=30104
 *
 * [378] 有序矩阵中第 K 小的元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthSmallestElementInASortedMatrix {

    // @lc code=start
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
                return a[0] - b[0];
            });
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[] { matrix[i][0], i, 0 });
            }

            int res = -1;
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                k--;
                int i = cur[1], j = cur[2];
                if (j + 1 < matrix[i].length) {
                    pq.add(new int[] { matrix[i][j + 1], i, j + 1 });
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [[1,5,9],[10,11,13],[12,13,15]]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[-5]]\n1\n
 * // @lcpr case=end
 * 
 */
