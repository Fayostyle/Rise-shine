/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if(array.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<array.length; i++) {
            if(map.containsKey(pattern.charAt(i))) {

                if(!map.get(pattern.charAt(i)).equals(array[i])) {
                    return false;
                }
            } else {
                if(set.contains(array[i])) {
                    return false;
                }

                map.put(pattern.charAt(i), array[i]);
                set.add(array[i]);
            }
        }

        return true;
    }
    
}
// @lc code=end

