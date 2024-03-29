/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //========方案1 空间复杂度O(N)
        // Set<ListNode> set = new HashSet<>();
        // while(headA != null) {
        //     set.add(headA);
        //     headA = headA.next;
        // }

        // while(headB != null) {
        //     if(set.contains(headB)) return headB;
        //     headB = headB.next;
        // }

        // return null;


        //===========方案2 空间复杂度o(1) 时间复杂度O(M+N)
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            } else{
                p1 = p1.next;
            }

            if(p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
    

        }

        return p1;
    }
}
// @lc code=end

