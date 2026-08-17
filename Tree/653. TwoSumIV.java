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
     Stack<TreeNode>acs=new Stack<>();
     Stack<TreeNode>desc=new Stack<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        TreeNode node = root;
        while(node!=null){
            acs.push(node);
            node=node.left;
        }
        node  = root;
        while(node!=null){
            desc.push(node);
            node=node.right;
        }
        TreeNode left = getsmall();
        TreeNode right = getlarge();
        while((left!=null || right!=null) && (left!=right) && (left.val<=right.val) ){
             int sum = left.val+right.val;
             if(sum==k){
                return true;
             }
             if(sum<k){
                 left = getsmall();
             }
             else{
                right = getlarge();
             }

        }
        return false;

    }

    public TreeNode getsmall(){
        if(acs.isEmpty()){
            return null;
        }
        TreeNode t = acs.pop();
        TreeNode rightChild = t.right;
        while(rightChild!=null){
            acs.push(rightChild);
            rightChild = rightChild.left;
        }
        return t;
    }

    public TreeNode getlarge(){
        if(desc.isEmpty()){
            return null;
        }
        TreeNode t = desc.pop();
        TreeNode leftChild = t.left;
        while(leftChild!=null){
            desc.push(leftChild);
            leftChild = leftChild.right;
        }
        return t;
    }
     
}


