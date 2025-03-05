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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            while(st.size()>0 && list.get(i) > list.get(st.peek())){
                ans[st.pop()] =list.get(i);   
            }
            st.push(i);
        }
        return ans;
    }
}