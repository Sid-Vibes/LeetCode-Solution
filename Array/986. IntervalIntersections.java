class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        if(n==0 || m==0){
            return new int [0][0];
        }
        List<int[]>res = new ArrayList<>();
        int idx=0;
        int i=0;
        int j=0;
         while(i<n && j<m){
            int start1=firstList[i][0];
            int end1=firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
               int end= Math.min(end1,end2);
               int start = Math.max(start1,start2);
               if(start<=end){
               res.add(new int[]{start,end});
               idx++;
               }
    
            if(end1<=end2){
                i++;
            }
            else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

