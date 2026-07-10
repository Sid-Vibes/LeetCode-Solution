class Solution {
    public int scheduleCourse(int[][] courses) {
         Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        int days=0;
        for(int [] c:courses){
            days+=c[0];    
            pq.offer(c[0]);

            if(days>c[1]){
               days-= pq.poll();
            }
        }
        return pq.size();
    }
}
