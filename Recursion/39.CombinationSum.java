class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer>diary=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        int sum=0;
        int idx=0;
        combination(candidates,n,idx,sum,diary,res,target);
        return res;
    }
    public void combination(int [] arr,int n,int idx,int sum,List<Integer>diary,List<List<Integer>>res,int target){
        if(idx==n){
            if(sum==target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }
        combination(arr,n,idx+1,sum,diary,res,target);
        if(arr[idx]+sum<=target){
            sum=sum+arr[idx];
            diary.add(arr[idx]);
            combination(arr,n,idx,sum,diary,res,target);
            diary.remove(diary.size()-1);
            sum=sum-arr[idx];
        }
        return;
    }
}
