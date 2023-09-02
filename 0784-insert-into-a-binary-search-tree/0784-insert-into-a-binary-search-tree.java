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
    public TreeNode solution(TreeNode root, int val){
        if(root==null){
            //if at the left and or right end we reach the last node then just insert
            TreeNode newnode = new TreeNode(val);
            return newnode;
        }
        if(root.val == val) return root;

        if(root.val < val){ // new value greater than root so go right
            root.right = solution(root.right, val);
        }
        else if(root.val > val){ // new value greater than root so go right
            root.left = solution(root.left, val);
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {

        return solution(root, val);
    }
}