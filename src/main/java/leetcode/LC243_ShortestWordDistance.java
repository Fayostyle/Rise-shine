package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC243_ShortestWordDistance {

    //    O(N^2)
    public static int shortestDistance2(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }
        return res;
    }

    //    O(N * logM)
    public static int shortestDistance1(String[] words, String word1, String word2) {
return 0;

    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect","perfect","practice", "coding", "makes"};
        String word1 = "perfect";
        String word2 = "practice";

        System.out.println(shortestDistance2(words,word1,word2));

    }
}
