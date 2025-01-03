# Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode resHead = new ListNode();
        ListNode tempres = resHead;
        int carry = 0;

        while(temp1 != null || temp2 != null) {
            int v1 = (temp1 != null) ? temp1.val : 0;
            int v2 = (temp2 != null) ? temp2.val : 0;

            int result = v1 + v2 + carry;
            tempres.next = new ListNode(result % 10);
            carry = result / 10;
            tempres = tempres.next;
            if (temp1 != null)
            temp1 = temp1.next;

            if (temp2 != null)
            temp2 = temp2.next;
        }

        if(carry != 0)
        tempres.next = new ListNode(carry);


        return resHead.next;
    }
}