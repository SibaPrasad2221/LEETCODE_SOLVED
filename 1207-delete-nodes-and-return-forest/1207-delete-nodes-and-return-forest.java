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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        //TC: O(N) as we are travelling through bfs for n no of nodes.
        //SC: O(N)

        //we will use bottom up approach becauses if we want to delete one node , next nodes won't be catured by any other method so we willl use dfs postt order
        List<TreeNode> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for(int ele:to_delete){
            set.add(ele);
        }

        helper_dfs_postOrder(root, set, ans);

        if(!set.contains(root.val)){ //if main root is not there in set, then we hsouldn't delete root so add it to answer
            ans.add(root);
        }

        return ans;
    }

    public TreeNode helper_dfs_postOrder(TreeNode root, HashSet<Integer> set, List<TreeNode> ans){
        if(root==null) return null;

        //we need to store them in root.left and root.right because when we return back we should point the root what result is found from left and right
        root.left = helper_dfs_postOrder(root.left, set, ans);
        root.right = helper_dfs_postOrder(root.right, set, ans);

        if(set.contains(root.val)){

            //if we found the eleemnt to delete first store it's child to answer then return and instruct the parent that it's child node is null as we deleted that node
            if(root.left != null) ans.add(root.left); 
            if(root.right != null) ans.add(root.right); 

            return null;
        }

        return root; //once everything is done return the root
    }
    
}