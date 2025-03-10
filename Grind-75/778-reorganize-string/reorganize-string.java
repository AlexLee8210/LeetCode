class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((Character a, Character b) -> freq[b - 'a'] - freq[a - 'a']);
        
        for (char c : s.toCharArray()) {
            ++freq[c - 'a'];
        }


        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) continue;
            pq.offer(c);
            seen[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char c1 = pq.poll();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c1) return "";
            sb.append(c1);
            --freq[c1 - 'a'];

            if (pq.isEmpty()) {
                if (freq[c1 - 'a'] > 0) return "";
                return sb.toString();
            }
            
            char c2 = pq.poll();
            sb.append(c2);
            --freq[c2 - 'a'];

            if (freq[c1 - 'a'] > 0) pq.offer(c1);
            if (freq[c2 - 'a'] > 0) pq.offer(c2);
        }

        return sb.toString();
    }
}