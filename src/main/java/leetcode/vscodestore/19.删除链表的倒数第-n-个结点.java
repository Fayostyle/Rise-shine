/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先找到前一个，然后直接指向后一个
        
        //方法1
        // ListNode p = head;
        // int length=0;
        // while(p!=null) {
        //     length++;
        //     p = p.next;
        // }

        // if(length <= 1) return null;

        // if(length - n == 0) {
        //     return head.next;
        // }

        // //倒数第n个, 正数length-n次走到
        // p = head;
        // for(int i=1; i<length - n; i++) {
        //     p = p.next;
        // }

        // ListNode tt = p.next.next;
        // p.next = tt;
        //     return head;

        //========================方法2===========
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        for(int i=0; i<n+1; i++) {
            p = p.next;
        }

        ListNode p2 = dummy;
        while(p!=null) {
            p2 = p2.next;
            p = p.next;
        }
        p2.next = p2.next.next;

        return dummy.next;

        

    }

}
// @lc code=end

