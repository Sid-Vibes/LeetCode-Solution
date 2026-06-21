class Solution {
    public int hIndex(int[] citations) {
        int low=0;
        int high=citations.length-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(citations[guess]>=citations.length-guess){
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return citations.length-low;
    }
}
