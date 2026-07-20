class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<Integer>diary=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        int idx=0;
        combination(candidates,n,idx,diary,res,target);
        return res;
    }
     public void combination(int [] arr,int n,int idx,List<Integer>diary,List<List<Integer>>res,int target){
        if(target==0){
            res.add(new ArrayList(diary));
            return;
        }
        if(arr.length<=idx){
            return;
        }
        if(target<0){
            return;
        }
        diary.add(arr[idx]);
        target=target-arr[idx];
        combination(arr,n,idx+1,diary,res,target);
        diary.remove(diary.size()-1);
        target += arr[idx];
        while(n>idx+1 && arr[idx]==arr[idx+1]){
            idx++;
        }

        combination(arr,n,idx+1,diary,res,target);
        return;
    }
}
