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
    public List<Integer> rightSideView(TreeNode root) {
        //apply bfs to solve

        //TC: O(N), SC: O(2^H)

        List<Integer> res = new ArrayList<>();

        if(root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(q.size()>0){
            int size = q.size();
            // int last_node_of_the_level=-1;
            // while(size-->0)
            for(int i=0;i<size;i++){
                TreeNode rnode = q.remove();
                if(i==size-1) res.add(rnode.val); //it will only store the last node at each level
                if(rnode.left != null) q.add(rnode.left);
                if(rnode.right != null) q.add(rnode.right);
            }
        }

        return res;
    }
}