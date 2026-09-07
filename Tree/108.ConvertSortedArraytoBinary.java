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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length-1);
    }

    public TreeNode BST(int [] arr,int low,int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode node = new TreeNode();
        node.val=arr[mid];
        node.left = BST(arr,low,mid-1);
        node.right = BST(arr,mid+1,high);
        return node;
    }
}
