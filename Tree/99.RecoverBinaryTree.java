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
    TreeNode prevNode  = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode secondfirst = null;
    TreeNode secsecond = null;
    int count =0;
    public void recoverTree(TreeNode root) {
         TreeNode node = validate(root);
         if(count==1){
            swap(firstNode,secondNode);
         }
         else{
             swap(firstNode,secsecond);
         }
         return;

    }
    public TreeNode validate(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left = validate(root.left);
        if(prevNode==null){
            prevNode = root;
        }
        else{
            if(count==0)
            {
              if(prevNode.val>=root.val)
               {
                firstNode = prevNode;
                secondNode = root;
                count++;
               }
            }
            else{
               if(prevNode.val>=root.val)
               {
               secondfirst = prevNode;
               secsecond = root;
               count++;
               }
               
            }
           prevNode = root;
        }
        TreeNode right = validate(root.right);
        return root;
    }
    public void swap(TreeNode p1, TreeNode p2){
        int k = p1.val;
        p1.val = p2.val;
        p2.val = k;
    }
}
