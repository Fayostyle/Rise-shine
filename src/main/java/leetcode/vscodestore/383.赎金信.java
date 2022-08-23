/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteInt = new int[26];
        for(char c : magazine.toCharArray()) {
            ransomNoteInt[c-'a']++;
        }
        for(char c : ransomNote.toCharArray()) {
            if(ransomNoteInt[c-'a'] == 0) {
                return false;
            }
            ransomNoteInt[c-'a']--;
        }
        return true;

    }
}
// @lc code=end

