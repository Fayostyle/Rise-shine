/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = new ListNode();
        ListNode p = head;

        // PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) -> (a.val - b.val));
        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        while(!pq.isEmpty()) {
            ListNode t = pq.poll();
            if(t.next != null) {
                pq.add(t.next);
            }

            p.next = t;
            p = p.next;
        }
        return head.next;
    }
}
// @lc code=end

