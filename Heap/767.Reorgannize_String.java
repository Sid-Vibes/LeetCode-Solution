class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
          PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

         for(char ch:map.keySet()){
            pq.offer(new Pair(ch,map.get(ch)));
        }
          StringBuilder ans = new StringBuilder();

        while (pq.size() > 1) {
            Pair first = pq.poll();
            Pair second = pq.poll();

            ans.append(first.ch);
            ans.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0) {
                pq.offer(first);
            }

            if (second.freq > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {
            Pair last = pq.poll();

            if (last.freq > 1) {
                return "";
            }

            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == last.ch) {
                return "";
            }

            ans.append(last.ch);
        }

        return ans.toString();
        
    }
}
class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
