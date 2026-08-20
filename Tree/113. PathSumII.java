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
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        List<Integer>diary=new ArrayList<>();
        path(root,sum,targetSum,diary);
        return res;
    }

    public void path(TreeNode root,int sum,int targetSum,List<Integer>diary){
        if(root==null){
            return;
        }
        sum = sum+root.val;
        diary.add(root.val);
        if(root.left==null && root.right==null){
           if(sum==targetSum){
               res.add(new ArrayList<>(diary));
            }
            diary.remove(diary.size() - 1);
            return;
        }

        path(root.left,sum,targetSum,diary);
        path(root.right,sum,targetSum,diary);

        diary.remove(diary.size()-1);

        return;
    }
}
