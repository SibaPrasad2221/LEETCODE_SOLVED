
class Solution {
    public boolean isSymmetric(TreeNode root) {

        // Create a queue to help compare nodes in pairs
        Queue<TreeNode> queueOfNodes = new LinkedList<>();

        // Add the left and right children of the root to the queue
        queueOfNodes.add(root.left);
        queueOfNodes.add(root.right);

        // Continue processing as long as there are nodes in the queue
        while (!queueOfNodes.isEmpty()) {

            // Get the next pair of nodes from the queue
            TreeNode left = queueOfNodes.poll();
            TreeNode right = queueOfNodes.poll();

            // If both nodes are null, continue to the next pair (they are symmetric at this level)
            if (left == null && right == null) 
                continue;

            // If one node is null and the other is not, the tree is not symmetric
            if (left == null || right == null)
                return false;

            // If the values of the two nodes are different, the tree is not symmetric
            if (left.val != right.val)
                return false;

            // Add the next level of nodes to the queue
            // Check the outer pair: left's left with right's right
            queueOfNodes.add(left.left);
            queueOfNodes.add(right.right);

            // Check the inner pair: left's right with right's left
            queueOfNodes.add(left.right);
            queueOfNodes.add(right.left);
        }

        // If all pairs are symmetric, return true
        return true;
    }
}
