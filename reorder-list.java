# Reorder List
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
    public void reorderList(ListNode head) {
        
        int count = 0;
        ListNode temp = head;

        while(temp != null) {
            count++;
            temp = temp.next;
        }

        count = (int) Math.ceil(count/2.0);

        int i = 1;
        ListNode newHead = head;
        ListNode prev = head;

        while(i <= count) {
            prev = newHead;
            newHead = newHead.next;
            i++;
        }

        prev.next = null;
        
        newHead = reverse(newHead);

        ListNode first = head;
        ListNode second = newHead;

        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;

        }
        

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}