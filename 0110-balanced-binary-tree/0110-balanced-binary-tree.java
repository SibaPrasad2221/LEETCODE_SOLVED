/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //to find height of a tree
    public int height(TreeNode node){
        if(node == null) return 0;

        int left_ht = height(node.left);
        int right_ht = height(node.right);

        int ans = 1 + Math.max(left_ht,right_ht);
        return ans;
    }

    public boolean isBalanced(TreeNode root) {

        //TC: O(N)
        //SC: O(N)
        
        if(root==null) return true;

        int left_height = height(root.left);
        int right_height = height(root.right);

        int diff = Math.abs(left_height-right_height);

        boolean ans1 = (diff<=1);
        boolean is_lst_balanced = isBalanced(root.left);
        boolean is_rst_balanced = isBalanced(root.right);

        if(ans1 && is_lst_balanced && is_rst_balanced) return true;
        return false;
    }
}