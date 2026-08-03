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
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       List<List<Integer>>res=new ArrayList<>();
       if(root==null){
         return new ArrayList<>();
       }
      queue.offer(root);  
      while(queue.size()!=0){
         List<Integer>temp=new ArrayList<>();
         int size = queue.size();
         
         while(size>0){
            TreeNode t = queue.poll();
            temp.add(t.val);
            if(t.left!=null){
                queue.offer(t.left);
            }
            if(t.right!=null){
                queue.offer(t.right);
            }
            size--;
         }
           res.add(temp);
      }
            return res;
    }
}
