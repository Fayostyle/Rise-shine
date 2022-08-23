/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for(String str : strs) {
            boolean flag = false;
            for(List<String> list : res) {
                if(group(list, str)) {
                    list.add(str);
                    flag = true;
                }
            }
            if(!flag) {
                List<String> f = new ArrayList<>();
                f.add(str);
                res.add(f);
            }
        }

        return res;
    }

    public boolean group(List<String> list, String str) {
        String first = list.get(0);
        if(first.length() != str.length()) {
            return false;
        }
        char[] fArray = first.toCharArray();
        char[] strArray = str.toCharArray();
        
        int[] map = new int[26];
        for(int i=0; i<first.length(); i++) {
            map[first.charAt(i) - 'a']++;
            map[str.charAt(i) - 'a']--;
    
        }

        for(int i : map) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    
    }
}

// @lc code=end

