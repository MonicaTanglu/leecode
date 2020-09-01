/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        int x = -2147483648;
        int sum = new Solution().reverse(x);
        System.out.println(sum);
    }

    public int reverse(int x) {
        int flag = 1, sum;
        StringBuilder sb;
        String eimStr;
        if (x < 0) {
            flag = -1;
            sb = new StringBuilder(String.valueOf(x).substring(1));
        } else {
            sb = new StringBuilder(String.valueOf(x));
        }
        eimStr = sb.reverse().toString();
        try {
            sum = Integer.valueOf(eimStr) * flag;
        } catch (Exception e) {
            sum = 0;
        }
        return sum;
    }
}
// @lc code=end
