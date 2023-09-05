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
    public void inorder(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right, res);
    }
    public boolean findTarget(TreeNode root, int k) {
        //we can perform DFS variation ie; Inorder traversal to solve this

        //Inorder traversal always gives you sorted array for a BST

        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);

        //res arraylist contains all node values in sorted order
        //we can search for pair whose sum to K using two pointer

        int sp=0;
        int ep= res.size()-1;
        int sum =0;
        while(sp<ep){
            sum = res.get(sp)+ res.get(ep);
            if(sum == k) return true;

            if(sum > k) ep--;
            if(sum < k) sp++;
        }
        return false;

    }
}