class TimeMap {
    private Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new TreeMap<>());
        }
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        TreeMap<Integer, String> history = store.get(key);

        Integer tsKey = history.floorKey(timestamp);
        if (tsKey == null) return "";
        return history.get(tsKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */