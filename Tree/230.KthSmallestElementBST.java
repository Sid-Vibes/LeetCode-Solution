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
    Stack<TreeNode>asc=new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        TreeNode node = root;
        while(node!=null){
           asc.push(node);
           node=node.left;
        }
        TreeNode first = null;
        while(k>0){
            first = getsmall();
           k--;
        }
        return first.val;

        
    }
    public TreeNode getsmall(){
        TreeNode t = asc.pop();
        TreeNode right = t.right;
        while(right!=null){
            asc.push(right);
            right=right.left;
        }
         return t;
    }
}
