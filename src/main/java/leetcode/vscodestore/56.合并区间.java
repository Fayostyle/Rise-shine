/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int idx = 0;
        int n = intervals.length;

        if(n <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }

        });

        List<int[]> res = new LinkedList<>();

        while(idx < n) {
            int s = intervals[idx][0];
            int b = intervals[idx][1];
            while(idx < n-1 && intervals[idx+1][0] <= b) {
                s = Math.min(s, intervals[idx+1][0]);
                b = Math.max(b, intervals[idx+1][1]);
                idx++;
            }
            intervals[idx][0] = s;
            intervals[idx][1] = b;
            res.add(intervals[idx++]);
            
        }

        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

