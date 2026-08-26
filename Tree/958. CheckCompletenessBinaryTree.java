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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean res = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node==null){
                    res = true;
                }
                else{
                  if(res){
                     return false;
                    }
                        queue.add(node.left);
                        queue.add(node.right); 
                }
            }
         return true;
    } 
   
}
