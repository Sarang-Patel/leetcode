# Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;

        ListNode temp = head;
        while(temp != null) {
            count += 1;
            temp = temp.next;
        }

        if(count == k) return head;

        if(count < k) k = k % count;

        ListNode slow = head;
        ListNode fast = head;

        int i = 0;

        while(i < k) {
            fast = fast.next;
            i++;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;

        ListNode result = slow.next;

        slow.next = null;

        return result;
    }
}