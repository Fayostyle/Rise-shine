## 递归与动态规划
This is a dynamic programming question. Usually, solving and fully understanding a dynamic programming problem is a 4 step process:

1. Start with the recursive backtracking solution
2. Optimize by using a memoization table (top-down dynamic programming)
3. Remove the need for recursion (bottom-up dynamic programming)
4. Apply final tricks to reduce the time / memory complexity


这是一个动态编程问题，通常，完全理解并解决一个动态编程问题是个4个步骤的过程：
1. 从递归回溯解决方案开始
2. 通过使用记忆化的表格进行优化（自顶向下递归的同时，保存中间态，存储中间过程的结果，减少重复计算量。
）
3. 消除递归操作。（自底向上的动态编程，从已知条件计算出全部后续状态结果，仍然存储中间过程的结果）
4. 应用最终技巧来降低时间空间复杂度。优化。观察题目，看是否有简便方法，可以直接得出答案省去中间步骤。 通常想到贪婪。

The question left unanswered is how should one approach such a question in an interview scenario. I would say "it depends". The perfect solution is cleaner and shorter than all the other versions, but it might not be so straightforward to figure out.
The (recursive) backtracking is the easiest to figure out, so it is worth mentioning it verbally while warming up for the tougher challenge. It might be that your interviewer actually wants to see that solution, but if not, mention that there might be a dynamic programming solution and try to think how could you use a memoization table. If you figure it out and the interviewer wants you to go for the top-down approach, it will not generally be time to think of the bottom-up version, but I would always mention the advantages of this technique as a final thought in the interview.
Most people are stuck when converting from top-down Dynamic Programming (expressed naturally in recursion) to bottom-up. Practicing similar problems will help bridge this gap.


没有回答的问题是如何在面试场景中处理这样的问题。我会说“看情况”。

完美的解决方案比所有其他版本更清洁，更短

但可能不是那么容易理解。
（递归）回溯是最容易弄清楚的，所以在为更严峻的挑战做准备时，值得口头提一下。
可能是你的面试官实际上想要看到这个解决方案，但如果没有，请提一下可能有动态编
程解决方案，并试着想一下如何使用memoization表。如果你弄明白并且面试官希望你
采用自上而下的方法，通常不会想到自下而上的版本，但我总是会提到这种技术的优点作
为面试的最终想法。
从自上而下的动态编程（自然地在递归中表达）转换为自下而上时，大多数人都陷入困境。
实践类似的问题将有助于弥合这一差距。