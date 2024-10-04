class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int l = 0, r = skill.length - 1;
        int cur = skill[0] + skill[skill.length - 1];
        long total = 0;
        while (l < r) {
            total += skill[l] * skill[r];
            if (skill[l++] + skill[r--] != cur) {
                return -1;
            }
        }
        return total;
    }
}