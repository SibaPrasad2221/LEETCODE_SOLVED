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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode next=null;
        ListNode prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
         //Your code here
        int len=0;
        ListNode curr=head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        
        curr=head;
        
        //if only one elements
        if(len==1){
            return true;
        }
        
        int steps=len/2-1;

        while(steps>0){
            curr=curr.next;
            steps--;
        }
        
        
        ListNode secondHead;
        if(len%2==0){
            secondHead=curr.next;
        }else{
            secondHead=curr.next.next; //if length of ll is odd then skip the middle element
        }
        curr.next=null;//break the connection
        
        secondHead=reverse(secondHead); //reversing the second half
        
        ListNode firstHead=head;
        
        while(firstHead!=null && secondHead!=null){
            if(firstHead.val!=secondHead.val){
                return false;
            }
            firstHead=firstHead.next;
            secondHead=secondHead.next;
        }
        
        return true;
        
    }
}