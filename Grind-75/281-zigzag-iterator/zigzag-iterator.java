public class ZigzagIterator {

    Iterator<Integer> it1;
    Iterator<Integer> it2;
    boolean one;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        one = false;
    }

    public int next() {
        one = !one;
        if (one && it1.hasNext()) {
            return it1.next();
        } else if (!one && it2.hasNext()) {
            return it2.next();
        } else if (it1.hasNext()) {
            return it1.next();
        } else {
            return it2.next();
        }
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */