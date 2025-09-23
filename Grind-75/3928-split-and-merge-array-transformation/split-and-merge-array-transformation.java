class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        if (Arrays.equals(nums1, nums2)) return 0;

        int n = nums1.length;
        Queue<List<Integer>> q = new LinkedList<>();
        Set<List<Integer>> vis = new HashSet<>();
        q.offer(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        vis.add(q.peek());

        List<Integer> expected = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        int depth = 0;
        while (!q.isEmpty()) {
            ++depth;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> s = q.poll();
                System.out.println(s);
                for (int l = 0; l < n; ++l) {
                    for (int r = l; r < n; ++r) {
                        List<Integer> left = new ArrayList<>(s.subList(0, l));
                        List<Integer> mid = new ArrayList<>(s.subList(l, r + 1));
                        List<Integer> right = new ArrayList<>(s.subList(r + 1, n));

                        List<Integer> removed = new ArrayList<>();
                        removed.addAll(left);
                        removed.addAll(right);

                        for (int idx = 0; idx < n - (r - l + 1); ++idx) {
                            if (idx == l) continue;
                            List<Integer> res = new ArrayList<>(removed);
                            res.addAll(idx, mid);
                            if (!vis.contains(res)) {
                                if (res.equals(expected)) {
                                    return depth;
                                }
                                q.offer(res);
                                vis.add(res);
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}