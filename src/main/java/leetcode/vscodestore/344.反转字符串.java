/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int l = s.length / 2;
        for(int i=0; i<l; i++) {
            swap(s, i, s.length -i -1);
        }
        
    }

    public void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
// @lc code=end

