class Solution {
    public void gameOfLife(int[][] board) {
		int[] nei = {0,1,-1};
		int rows = board.length;
		int cols = board[0].length;
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				int liveCount = 0;
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						
						if(!(i == 0 && j == 0)) {
							int tr = r + nei[i];
							int tc = c + nei[j];
							
							if(tr >= 0 && tr < rows && tc >= 0 && tc < cols && Math.abs(board[tr][tc]) == 1) {
								liveCount++;
							}
						}
						
						
					}
				}
				
				if(board[r][c] == 1 && (liveCount < 2 || liveCount > 3)) {
					board[r][c] = -1;
				}
				if(board[r][c] == 0 && liveCount == 3) {
					board[r][c] = 2;
				}
					
			}
		}
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				board[r][c] = board[r][c] == 2 ? 1 : board[r][c];
				board[r][c] = board[r][c] == -1 ? 0 : board[r][c];
	
			}
		}
	}
}

/*
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

 

示例：

输入： 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出：
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
 

进阶：

你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/game-of-life
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/