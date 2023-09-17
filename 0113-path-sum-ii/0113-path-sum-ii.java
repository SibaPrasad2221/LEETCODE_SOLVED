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
    public List<List<Integer>> dfs(TreeNode root, int sum_so_far, int targetSum, List<List<Integer>> ans, List<Integer> sub_list){

        if(root == null) return ans;

        sub_list.add(root.val);

        //if it's a leaf node
        if(root.left==null && root.right==null){
            if(sum_so_far + root.val== targetSum){
                ans.add(new ArrayList<>(sub_list));
            }
        }

        dfs(root.left, sum_so_far+root.val, targetSum, ans, sub_list);
        dfs(root.right, sum_so_far+root.val, targetSum, ans, sub_list);

        sub_list.remove(sub_list.size()-1); //now remove last leaf node and check with other right or left leaf value
        return ans;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub_list = new ArrayList<>();
        int sum_so_far=0;

        if(root==null) return ans;

        dfs(root,sum_so_far, targetSum, ans, sub_list);
        return ans;
    }
}