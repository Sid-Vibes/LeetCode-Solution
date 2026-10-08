class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : wordList) {
            map.put(word, 1);
        }

        if (!map.containsKey(beginWord)) {
            map.put(beginWord, 1);
        }

        if (!map.containsKey(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            String s = p.first;
            int val = p.second;

            if (s.equals(endWord)) {
                return val;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                for (char j = 'a'; j <= 'z'; j++) {
                    if (c == j) {
                        continue;
                    }

                    String newWord = s.substring(0, i) + j + s.substring(i + 1);

                    if (map.containsKey(newWord)) {
                        queue.offer(new Pair(newWord, val + 1));
                        map.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}    

class Pair{
     String first;
     int second;

     Pair(String first,int second){
         this.first=first;
         this.second=second;
     }
}
