/**
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 

示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 
**/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][];
        if(intervals.length == 0) {
            res[0] = newInterval;
            return res;
        }
        int n1 = newInterval[0];
        int n2 = newInterval[1];
        for(int i=0; i<intervals.length; ) {
            int[] cur = intervals[i];
            int small = cur[0];
            int big = cur[1];
            while((n1 >= small && n1 <= big) || (n2 >= small && n2 <= big) || )) {
                n1 = Math.min(small, n1);
                n2 = Math.max(big, n2);
                
            }
        }

        int i = 0;
        while()
    }
}