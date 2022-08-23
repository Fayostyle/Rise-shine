/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while(left <= right && s.charAt(left) == ' ') left++;
        while(left <= right && s.charAt(right) == ' ') right--;

        Deque<String> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char c = s.charAt(left);
            if(sb.length() != 0 && c == ' '){
                d.offerFirst(sb.toString());
                sb.setLength(0);
            } else if(c != ' ') {
                sb.append(c);
            } else {
                //sb.length() == 0 and c == ' '
                //ignore no possible happen
            }
            left++;
        }

        //last word append
        d.offerFirst(sb.toString());
        return String.join(" ", d);
        
    }

 
}
// @lc code=end

class Solution {
    public String reverseWords(String s) {
       
            s = s.trim();
            List<String> list = Arrays.asList(s.split("\\s+"));
            Collections.reverse(list);
            return String.join(" ", list);
        
        
    }

 
}

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
        
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0; 
        int right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' ') left++;
        while(right >= left && s.charAt(right) == ' ') right--;
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char c = s.charAt(left);
            if(c != ' ') {
                sb.append(c);
            } else if(sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }

            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int start, int end) {
        while(start <= end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, tmp);

        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int l = sb.length();
        int start = 0;
        int end = 0;
        while(start < l) {
            while(end < l && sb.charAt(end) != ' '){
                end++;
            }
            reverse(sb, start, end - 1);
            end++;
            start = end;
        }
    }
}

leetcode186. 翻转字符串里的单词 II
给定一个字符串，逐个翻转字符串中的每个单词。

示例：

输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
注意：

单词的定义是不包含空格的一系列字符
输入字符串中不会包含前置或尾随的空格
单词与单词之间永远是以单个空格隔开的
进阶：使用 O(1) 额外空间复杂度的原地解法。

思路：先反转每个单词，然后总体再翻转。

class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        int start = 0;
        for(int i=0; i<n; i++) {
            char c = s[i];
            if(c == ' ') {
                reverseEachWord(s, start, i-1);
                start = i + 1;
            }
        }
        reverseEachWord(s, start, n-1);
        reverseEachWord(s, 0, n-1);
    }

    public void reverseEachWord(char[] s, int start, int end) {
        while(start <= end) {
            char tmp = s[start];
            s[start++] = s[end];
            start[end--] = tmp;
        }
    }
}