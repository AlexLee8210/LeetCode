class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int water = 0;
        for (int i = -1; i < plants.length - 1; ++i) {
            if (water < plants[i + 1]) {
                water = capacity;
                steps += (i + 1) * 2;
            }
            ++steps;
            water -= plants[i + 1];
        }

        return steps;
    }
}