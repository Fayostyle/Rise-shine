/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
    }

}
// @lc code=end

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        
        }

        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            prefix = getLongestPrefix(prefix, strs[i]);
            if(prefix.length() == 0) {
                break;
            }
        }

        return prefix;

    }

    public String getLongestPrefix(String prefix, String str) {
        int min = Math.min(prefix.length(), str.length());
        int i=0;
        while(i < min && prefix.charAt(i) == str.charAt(i)) {

            i++;
        }
        return prefix.substring(0, i);
    }
}   

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        
        }

        int length = strs[0].length();
        int count = strs.length;
        for(int i=0; i<length; i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j<count; j++) {
                if(i == strs[j].length() || c != strs[j].charAt(i) ) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }


}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        } else {
            return getLongestPrefix(strs, 0, strs.length-1);
        }

    }

    public String getLongestPrefix(String[] strs, int start, int end) {
        if(start == end) {
            return strs[start];
        }
        int mid = start + (end - start) / 2;
        String left = getLongestPrefix(strs, start, mid);
        String right = getLongestPrefix(strs, mid + 1, end);
        return commonPrefix(left, right);
    }

    public String commonPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        int i=0;
        while(i<min && s1.charAt(i) == s2.charAt(i)) {
            i++;

        }
        return s1.substring(0, i);
    }


}