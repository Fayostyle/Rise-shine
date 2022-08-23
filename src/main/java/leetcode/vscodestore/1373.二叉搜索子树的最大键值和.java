/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        System.out.println(max);
        traverse(root);
        return max;
    }

    public int[] traverse(TreeNode root) {
        if(root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        if(left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(root.val, left[1]);
            res[2] = Math.max(root.val, right[2]);
            res[3] = left[3] + right[3] + root.val;

            max = Math.max(max, res[3]);


        } else {
            res[0] = 0;
        }

        return res;
    }
}



//     public void traverse(TreeNode root) {
//         if(root == null) return;

//         traverse(root.left);
//         traverse(root.right);

//         if(!isValid(root.left) || !isValid(root.right)) {
//             return;
//         }

//         int leftMax = getMax(root.left);
//         int rightMin = getMin(root.right);

//         if(leftMax >= root.val || rightMin <= root.val) return;

//         int leftSum = findSum(root.left);
//         int rightSum = findSum(root.right);

//         int res = leftSum + rightSum + root.val;
//         System.out.println("max:"+max);
//         System.out.println("res:"+res);
//         this.max = Math.max(this.max, res);


        
//     }


//     public boolean isValid(TreeNode root) {
//         return checkValidHelper(root, null, null);
//     }

//     public boolean checkValidHelper(TreeNode root, TreeNode min, TreeNode max) {
//         if(root == null) return true;
//         if(min != null && min.val >= root.val) return false;
//         if(max != null && max.val <= root.val) return false;

//         return checkValidHelper(root.left, min, root) && checkValidHelper(root.right, root, max);
//     }

//     public int getMax(TreeNode root) {
//         if(root == null) return Integer.MIN_VALUE;
//         while(root.right != null) {
//             root = root.right;
//         }
//         return root.val;
//     }

//     public int getMin(TreeNode root) {
//         if(root == null) return Integer.MAX_VALUE;
//         while(root.left !=null) root = root.left;
//         return root.val;

//     }

//     public int findSum(TreeNode root) {
//         if(root == null) return 0;
//         int leftSum = findSum(root.left);
//         int rightSum = findSum(root.right);
//         return leftSum + rightSum + root.val;
//     }


// }
// @lc code=end

