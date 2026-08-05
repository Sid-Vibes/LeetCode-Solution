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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode>node = new LinkedList<>();
        node.offer(root);
        int size = node.size();
        while(!node.isEmpty()){
              TreeNode t = node.poll();
          
            TreeNode temp = t.left;
            t.left = t.right;
            t.right = temp;
            if(t.left!=null){
              node.offer(t.left);
           }
            if(t.right!=null){
                 node.offer(t.right);
            }
        
        }
        return root;
    }
}
