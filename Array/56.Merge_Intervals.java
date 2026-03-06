class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
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
