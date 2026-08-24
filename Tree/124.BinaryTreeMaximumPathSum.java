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
    public int maxPathSum(TreeNode root) {  
        int maxi [] = new int [1];
        maxi[0]=Integer.MIN_VALUE;
        path(root,maxi);
        return maxi[0];
    }
    public int path(TreeNode root,int maxi[]){
        if(root==null){
            return 0;
        }
       int leftsum = Math.max(0,path(root.left,maxi));
       int rightsum = Math.max(0,path(root.right,maxi));

       maxi[0] = Math.max(maxi[0],leftsum+rightsum+root.val);

       return Math.max(leftsum,rightsum)+root.val;
    }
}   
