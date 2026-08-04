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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
       List<List<Integer>>res=new ArrayList<>();
       if(root==null){
         return new ArrayList<>();
       }
      queue.offer(root);  
      int ZigZag=0;
      while(queue.size()!=0){
         List<Integer>temp=new ArrayList<>();
         int size = queue.size();
         while(size>0){
            TreeNode t = queue.poll();
            if (ZigZag == 0)
               temp.add(t.val);
            else
               temp.add(0, t.val);
            if(t.left!=null){
                queue.offer(t.left);
            }
            if(t.right!=null){
                queue.offer(t.right);
            } 
            size--;
         }
           ZigZag = 1-ZigZag;
           res.add(temp);
      }
            return res;
    }
}
