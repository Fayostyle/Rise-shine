/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
       char[] cs = s.toCharArray();
       int left = 0;
       int right = cs.length - 1;
       while(left < right) {
           while(left < right && !isVowel(cs[left])) left++;
           while(left < right && !isVowel(cs[right])) right--;
           if(left >= right) {
               break;
           }

           swap(cs, left++, right--);


       }
       return new String(cs);
    }

    public void swap(char[] c, int left, int right) {
        char tmp = c[left];
        c[left] = c[right];
        c[right] = tmp;
    }
    public boolean isVowel(char ch) {
        // 这里要直接用 return 语句返回，不要返回 true 或者 false
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
// @lc code=end

class Solution {
    public String reverseVowels(String s) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> vs = Arrays.asList(vowels);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(vs.contains(c)){
                list.add(i);
            }
        }
        char[] so = s.toCharArray();
        int left = 0; 
        int right = list.size() - 1;
        while(left < right) {
            char tmp = so[list.get(left)];
            so[list.get(left++)] = so[list.get(right)];
            so[list.get(right--)] = tmp;
        }

        return new String(so);
    }
}