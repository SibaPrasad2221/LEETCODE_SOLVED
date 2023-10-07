/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // class Pair{
    //     int val;
    //     int dist;
    //     Pair(int val,int dist){
    //         this.val = val;
    //         this.dist = dist;
    //     }
    // }

    void helper_n2p(TreeNode root,Map<TreeNode, TreeNode> n2p){ //pre order
        if(root==null) return;

        if(root.left!=null) n2p.put(root.left, root);
        if(root.right!=null) n2p.put(root.right, root);

        helper_n2p(root.left, n2p);
        helper_n2p(root.right, n2p);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //we need a hashamp containg all the nodes with it's parent node otherwise we can't go above of a node
        Map<TreeNode, TreeNode> n2p = new HashMap<>(); //node to parents;

        helper_n2p(root, n2p);

        //we need a visiting path record to keep checking whether the node we are visitng is a;ready visited or not otherwise we will face infinity loop error
        //we can create boolean visited array or visited hashet contains the node address uniquely if present then it's visited
        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();
        //target node address is given here, if the value is given then we would create another function to search
        q.add(target);  
        visited.add(target);

        int dist = 0;
        // ArrayList<Pair> distance_record = new ArrayList<>();
        // distance_record.add(new Pair(target, 0)); //target is at zeroth distance

        //peform bfs
        while(q.size()>0){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            while(size-->0){
                TreeNode curr = q.remove();

                //consider left child
                if(curr.left != null && visited.contains(curr.left)==false){
                    visited.add(curr.left);
                    q.add(curr.left);
                }
                
                //consider right child
                if(curr.right != null && visited.contains(curr.right)==false){
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                //consider parent if that node not visited yet.
                if(n2p.containsKey(curr) && visited.contains(n2p.get(curr))==false){
                    q.add(n2p.get(curr));
                    visited.add(n2p.get(curr));
                }

                // distance_record.add(new Pair(curr, dist));
                ans.add(curr.val);
            }
            if(dist==k){
                return ans;
            }
            dist++;
        }

        return new ArrayList<>();
    }
}