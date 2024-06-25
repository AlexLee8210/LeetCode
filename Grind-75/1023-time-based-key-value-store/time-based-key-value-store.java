class TimeMap {

    private class TimeValue {
        public String value;
        public int timestamp;
        public TimeValue(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    HashMap<String, ArrayList<TimeValue>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            ArrayList<TimeValue> list = new ArrayList<>();
            list.add(new TimeValue(value, timestamp));
            timeMap.put(key, list);
            return;
        }
        timeMap.get(key).add(new TimeValue(value, timestamp));
        // ArrayList<TimeValue> list = timeMap.get(key);
        // int l = 0, r = list.size() - 1;
        
        // while (l <= r) {
        //     int m = l + (r - l) / 2;
        //     if (list.get(m).timestamp < timestamp) {
        //         l = m + 1;
        //     } else {
        //         r = m - 1;
        //     }
        // }
        // list.set(l, new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        ArrayList<TimeValue> list = timeMap.get(key);

        int l = 0, r = list == null ? -1 : list.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m).timestamp <= timestamp) {
                l = m + 1;
                res = list.get(m).value;
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