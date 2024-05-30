class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals.sort(key=lambda x: x[0])
        res = []
        prev = None
        for inter in intervals:
            if prev is None:
                prev = inter
                continue
            
            if inter[0] <= prev[1]:
                prev[1] = max(inter[1], prev[1])
            else:
                res.append(prev)
                prev = inter
        res.append(prev)
        return res
        