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
    boolean res = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        check(root);
        return res;
    }
    public void check(TreeNode root){
       if(root==null){
        return;
       }
        check(root.left);
       if(prev==null){
           prev = root;
       }
       else{
          if(prev.val>=root.val){
             res = false;
          }
          prev = root;
       }

        check(root.right);
        
       return;
    }
}
