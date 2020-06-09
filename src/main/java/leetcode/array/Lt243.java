/**
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

思路：从左到右扫描，记录word1和word2的最新位置，比较两个最新位置的距离与最短距离。时间复杂度O(n)
————————————————
244 多次调用， 先把所有出现的放入list， 计算距离时通过word的key值拿出来list，再利用双指针（放进去list里面的下标是从小到大的），取得最小值
245 word1和word2相同的时候，作为不同的个体计算它们的距离。 在第一个if的地方，增加判断，当word1和word2相同，则pos1=pos2 保存下来pos2的值，
	由接下来的pos2去接收当前遍历的下标值，相当于二者以2的窗口向后平移了一个位置，但是交换了原本的前后顺序，达到相同值代表不同个体的目的。
*/

class Lt243{
	public int shortestDistance(String[] words, String word1, String word2) {
		int res = words.length - 1;
		int pos1=-1, pos2=-1;
		for(int i=0; i<words.length; i++) {
			if(word1.equals(words[i])) {
				pos1 = i;
				if(pos2 != -1) {
					res = Math.min(res, pos1 - pos2);
				}
			} else if(word2.equals(words[i])) {
				pos2 = i;
				if(pos1 != -1) {
					res = Math.min(res, pos2 - pos1);
				}
			}
		}
		return res;
	}
}