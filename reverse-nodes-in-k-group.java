# Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode result = new ListNode();
        ListNode res = result;

        ListNode temp = head;

        while(temp != null) {
            stack.offerLast(temp);
            temp = temp.next;
            
            if(stack.size() == k) {
                while(!stack.isEmpty()) {
                    ListNode node = stack.pollLast();

                    res.next = node;
                    res = res.next;
                    res.next = null;
                }
            }

        }

        if(!stack.isEmpty()) {
            res.next = stack.pollFirst();
        }

        return result.next;



    }
}