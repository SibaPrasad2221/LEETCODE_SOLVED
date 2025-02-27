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
    int cnt =0;
    public int dfs(TreeNode root, int x){
        if(root==null) return 0;
        if(root.val >= x){
            x = root.val;
            cnt++;
        }
        dfs(root.left, x);
        dfs(root.right, x);
        return cnt;

    }
    public int goodNodes(TreeNode root) {
        
        if(root==null) return 0;
        int x = root.val;
        return dfs(root, x);
    }
}