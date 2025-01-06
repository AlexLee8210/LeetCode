class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] arr = new int[s.length() + 1];

        for (int[] a : shifts) {
            int amount = a[2] == 1 ? 1 : -1;
            arr[a[0]] += amount;
            arr[a[1] + 1] -= amount;
        }
        
        int amount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            amount += arr[i];
            sb.append(shift(s.charAt(i), amount));
        }

        return sb.toString();
    }

    private char shift(char c, int amount) {
        int offset = c - 'a' + amount;
        offset = (offset % 26 + 26) % 26;
        return (char) (offset + 'a');
    }
}