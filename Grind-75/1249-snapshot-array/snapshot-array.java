class SnapshotArray {
    private int nextSnapId;
    private TreeMap<Integer, Integer>[] snapshots;

    public SnapshotArray(int length) {
        nextSnapId = 0;
        snapshots = new TreeMap[length];
        for (int i = 0; i < length; ++i) {
            snapshots[i] = new TreeMap<>();
            snapshots[i].put(nextSnapId, 0);
        }
    }
    
    public void set(int index, int val) {
        snapshots[index].put(nextSnapId, val);
    }
    
    public int snap() {
        return nextSnapId++;
    }
    
    public int get(int index, int snap_id) {
        return snapshots[index].get(snapshots[index].floorKey(snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */