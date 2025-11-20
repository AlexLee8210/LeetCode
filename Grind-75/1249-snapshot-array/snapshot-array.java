class SnapshotArray {
    private int nextSnapId;
    private List<int[]>[] snapshots;

    public SnapshotArray(int length) {
        nextSnapId = 0;
        snapshots = new ArrayList[length];
        for (int i = 0; i < length; ++i) {
            snapshots[i] = new ArrayList<>();
            snapshots[i].add(new int[]{nextSnapId, 0});
        }
    }
    
    public void set(int index, int val) {
        if (snapshots[index].getLast()[0] == nextSnapId) {
            snapshots[index].getLast()[1] = val;
        } else {
            snapshots[index].add(new int[]{nextSnapId, val});
        }
    }
    
    public int snap() {
        return nextSnapId++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = snapshots[index];
        int l = 0, r = list.size() - 1;
        int res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m)[0] < snap_id) {
                res = list.get(m)[1];
                l = m + 1;
            } else if (list.get(m)[0] > snap_id) {
                r = m - 1;
            } else {
                return list.get(m)[1];
            }
        }
        return res;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */