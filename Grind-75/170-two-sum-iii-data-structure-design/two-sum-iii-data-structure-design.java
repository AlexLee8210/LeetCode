class TwoSum {

    private HashMap<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, 2);
        } else {
            map.put(number, 1);
        }
    }
    
    public boolean find(int value) {
        for (int val : map.keySet()) {
            int tgt = value - val;
            if (map.containsKey(tgt)) {
                if (tgt != val || map.get(tgt) > 1) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */