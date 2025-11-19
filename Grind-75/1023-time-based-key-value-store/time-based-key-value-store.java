class TimeMap {
    private class TimeValue {
        private int timestamp;
        private String value;

        public TimeValue(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    private Map<String, ArrayList<TimeValue>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        ArrayList<TimeValue> history = store.get(key);

        int l = 0, r = history.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (history.get(m).timestamp <= timestamp) {
                l = m + 1;
                res = history.get(m).value;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */