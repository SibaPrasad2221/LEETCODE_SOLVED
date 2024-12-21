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
    public TreeNode reverseOddLevels(TreeNode root) {
        //level order traversal
        //bfs

        if(root==null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth =1;

        while(!q.isEmpty()){
            int size =q.size();
            ArrayList<TreeNode> oddlevel_nodes = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                oddlevel_nodes.add(curr);

                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
            depth++;


            if(depth%2!=0){
                int n=oddlevel_nodes.size();
                for(int i=0;i<n/2;i++){
                    int temp = oddlevel_nodes.get(i).val;
                    oddlevel_nodes.get(i).val = oddlevel_nodes.get(n-i-1).val;
                    oddlevel_nodes.get(n-i-1).val = temp;
                }
            }
        }

        return root;
    }
}