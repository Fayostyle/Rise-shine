/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
        递归解法
        先不关注原始方法签名是怎样的，而是实现自己的递归方法。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null) return null;

        if(p == root || q == root) return root;

        //递归调用， 获取左右子树上的寻找情况。 分为三种情况
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //情况判断
        //1 如果left 和 right都不为空， 说明一定是P，q 一定分布在root两端 ，当前root就是lca
        //上面讲的是整体上看递归的最终返回情况。假设现在进入某一步递归了，返回left right都不为空，说明一定是找到了p q两个节点， 根据base case  只有这两个节点出现，才会有不为null的返回。
        //由于使用的后续遍历，从遍历顺序图上也能看出，是叶子节点向根节点返回的，最先找到的就是最近的公共祖先
        if(left != null && right != null) {
            return root;
        }

        if(left == null && right == null) return null;

        return left != null ? left : right;


        
    }


    public TreeNode traverse(TreeNode root, TreeNode p, TreeNode q
    ) {
        return null;
    }
}
// @lc code=end

