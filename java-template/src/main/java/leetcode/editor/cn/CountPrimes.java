/*
 * @lc app=leetcode.cn id=204 lang=java
 * @lcpr version=30104
 *
 * [204] 计数质数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CountPrimes {

    // @lc code=start
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrim = new boolean[n];
            Arrays.fill(isPrim, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrim[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrim[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrim[i]) {
                    count++;
                }
            }
            return count;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// 10\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

