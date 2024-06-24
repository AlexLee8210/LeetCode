// class TimeMap {

//     private class TimeValue implements Comparable<TimeValue> {
//         public String value;
//         public int timestamp;
//         public TimeValue(String v, int t) {
//             value = v;
//             timestamp = t;
//         }

//         public int compareTo(TimeValue tv) {
//             return tv.timestamp - timestamp;
//         }

//         public boolean equals(Object o) {
//             TimeValue tv = (TimeValue) o;
//             return timestamp == tv.timestamp;
//         }
//     }

//     HashMap<String, TreeSet<TimeValue>> timeMap;

//     public TimeMap() {
//         timeMap = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         TreeSet<TimeValue> set = timeMap.getOrDefault(key, new TreeSet<>());
//         set.add(new TimeValue(value, timestamp));
//         timeMap.put(key, set);
//     }
    
//     public String get(String key, int timestamp) {
//         TreeSet set = timeMap.get(key);
//         String val = set.first().value;
//         if (set.contains(new TimeValue(val, timestamp))) {
//             return set.get().value;
//         }
//         return set.first().value;
//     }
// }

// /**
//  * Your TimeMap object will be instantiated and called as such:
//  * TimeMap obj = new TimeMap();
//  * obj.set(key,value,timestamp);
//  * String param_2 = obj.get(key,timestamp);
//  */

class TimeMap {

    HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tmap = timeMap.getOrDefault(key, new TreeMap<>());
        tmap.put(timestamp, value);
        timeMap.put(key, tmap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tmap = timeMap.get(key);
        if (tmap == null) return "";
        Integer floorTS = tmap.floorKey(timestamp);
        return floorTS == null ? "" : tmap.get(floorTS);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */