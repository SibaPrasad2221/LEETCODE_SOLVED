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
        //so kth from end means n-k+1 th from starting(becuz n-k reach til the previous val of target)

        ListNode curr = head;

        //count the length of ll
        int len =0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        //edge cases
        if(len == 1 && n==1) return null;

        int steps = len - n -1;
        curr = head;
        while(steps>0){
            curr = curr.next;
            steps--;
        }

        if(n==len){
            curr = curr.next;
            return curr;
        }

        //now curr reach the previous of the target index
        ListNode targetNode = curr.next;
        curr.next = curr.next.next;
        targetNode.next = null;

        return head;
    }
}