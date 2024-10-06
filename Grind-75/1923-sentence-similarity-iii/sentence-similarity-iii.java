class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == 0 || sentence2.length() == 0) return true;
        if (sentence1.length() > sentence2.length()) {
            String temp = sentence2;
            sentence2 = sentence1;
            sentence1 = temp;
        }

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int l = 0, r1 = s1.length - 1, r2 = s2.length - 1;

        while (l <= r1 && s1[l].equals(s2[l])) {
            ++l;
        }
        // System.out.println(l + ", " + r1 + ", " + r2);
        while (l <= r1 && s1[r1].equals(s2[r2])) {
            --r1;
            --r2;
        }
        // System.out.println(l + ", " + r1 + ", " + r2);
        return l > r1;
    }
}