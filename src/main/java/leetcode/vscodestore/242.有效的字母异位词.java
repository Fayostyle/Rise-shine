/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int l = s.length();
        int m = t.length();
        if(l != m) {
            return false;
        }

        int[] count = new int[26];
        for(int i=0; i<l; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

        }

        for(Integer c :count) {
            if(c != 0) {
                return false; 
            }
        }

        return true;
    }
}
// @lc code=end

