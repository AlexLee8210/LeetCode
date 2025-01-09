class Solution {
    private char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length + 1];
        for (int i = 0; i < words.length; ++i) {
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; ++i) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = prefix[end + 1] - prefix[start];
        }

        return ans;
    }

    private boolean isVowelString(String word) {
        boolean starts = false;
        boolean ends = false;
        
        for (char vowel : vowels) {
            if (word.charAt(0) == vowel) {
                starts = true;
                break;
            }
        }
        if (!starts) return false;
        for (char vowel : vowels) {
            if (word.charAt(word.length() - 1) == vowel) {
                ends = true;
                break;
            }
        }
        return ends;
    }
}