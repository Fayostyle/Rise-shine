/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return check(s).equals(check(t));
    }

    public String check(String s) {
        int[] map = new int[128];
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0; i<l; i++) {
            char c = s.charAt(i);
            if(map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }

        return sb.toString();
    }
    
}
// @lc code=end



class Solution {
    public boolean isIsomorphic(String s, String t) {
        return check(s, t) && check(t, s);
    }
    public boolean check(String s, String t) {
        int l = s.length();
        int tl = t.length();
        if(l != tl) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<l; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) != c2){
                    return false;
                }
            } else { 
                map.put(c1, c2);
            }
        }
        return true;
    }
}