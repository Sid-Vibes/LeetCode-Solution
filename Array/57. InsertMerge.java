class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] arr = new int[intervals.length+1][2];
        boolean flag = false;
        int idx=0;
        for(int i=0;i<intervals.length;i++){
            if(flag==false && intervals[i][0]>=newInterval[0]){
               arr[idx][0]=newInterval[0];
               arr[idx][1]=newInterval[1];
               flag=true;
               idx++;
            }
            arr[idx][0] = intervals[i][0];
            arr[idx][1] = intervals[i][1];
            idx++;
        }
         if(flag==false){
            arr[idx][0]=newInterval[0];
            arr[idx][1]=newInterval[1];
         }

        return merge(arr);  
    }

    public int [][] merge(int[][] intervals){
        int [][] res = new int [intervals.length][2];
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        int idx=0;
        for(int i=1;i<intervals.length;i++){
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            if(end1>=start2){
                start1=Math.min(start1,start2);
                end1=Math.max(end1,end2);
                continue;
            }
            else{
           res[idx][0]=start1;
           res[idx][1]=end1;
           end1=end2;
           start1=start2;
           idx++;
            }

        }
          res[idx][0]=start1;
          res[idx][1]=end1;
          return Arrays.copyOf(res,idx+1);
    }
}
