# Remove Nth Node From End of List
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
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode first = temp;
        ListNode second = temp;

        for(int i = 0; i <= n; i++) {
            first = first.next;
        }

        while(first != null) {

            first = first.next;
            second = second.next;

        }

        second.next = second.next.next;

        return temp.next;


    }
}