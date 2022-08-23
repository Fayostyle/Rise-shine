/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList();
        int idx = 0; 
        int n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        while(idx < n && newStart > intervals[idx][1]) {
            res.add(intervals[idx++]);
        }

        while(idx < n &&  newEnd >= intervals[idx][0]) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }

        newInterval[0] = newStart;
        newInterval[1] = newEnd;
        res.add(newInterval);

        while(idx < n && newEnd < intervals[idx][0]) {
            res.add(intervals[idx++]);
        }

        return res.toArray(new int[res.size()][2]);

        
    }
}
// @lc code=end

算法：

将 newInterval 之前开始的区间添加到输出。
添加 newInterval 到输出，若 newInterval 与输出中的最后一个区间重合则合并他们。
一个个添加区间到输出，若有重叠部分则合并他们。
PythonJava

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    // init data
    int newStart = newInterval[0], newEnd = newInterval[1];
    int idx = 0, n = intervals.length;
    LinkedList<int[]> output = new LinkedList<int[]>();

    // add all intervals starting before newInterval
    while (idx < n && newStart > intervals[idx][0])
      output.add(intervals[idx++]);

    // add newInterval
    int[] interval = new int[2];
    // if there is no overlap, just add the interval
    if (output.isEmpty() || output.getLast()[1] < newStart)
      output.add(newInterval);
    // if there is an overlap, merge with the last interval
    else {
      interval = output.removeLast();
      interval[1] = Math.max(interval[1], newEnd);
      output.add(interval);
    }

    // add next intervals, merge with newInterval if needed
    while (idx < n) {
      interval = intervals[idx++];
      int start = interval[0], end = interval[1];
      // if there is no overlap, just add an interval
      if (output.getLast()[1] < start) output.add(interval);
      // if there is an overlap, merge with the last interval
      else {
        interval = output.removeLast();
        interval[1] = Math.max(interval[1], end);
        output.add(interval);
      }
    }
    return output.toArray(new int[output.size()][2]);
  }
}
复杂度分析

时间复杂度：\mathcal{O}(N)O(N)。我们只遍历了一次输入元素。
空间复杂度：\mathcal{O}(N)O(N)，输出答案所使用的空间。

作者：LeetCode
链接：https://leetcode-cn.com/problems/insert-interval/solution/cha-ru-qu-jian-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。