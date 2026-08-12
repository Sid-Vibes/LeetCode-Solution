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
    TreeNode node = null;
    int Maxdepth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int max = 0;
         int res  = depestNode(root,max);
         return node;
    }

    public int depestNode(TreeNode root,int max){
      if(root==null){
        return max;
      }
      int left = depestNode(root.left,max+1);
      int right = depestNode(root.right,max+1);
      int prev = Math.max(left,right);
      if(left==right && left>=Maxdepth){
        Maxdepth = left;
        node = root;
      }
       return prev;
    }
}
