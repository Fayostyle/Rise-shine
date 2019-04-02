package leetcode;

public class LC55_JumpGame {
    //approach1 递归回溯
    public static  boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public static boolean canJumpFromPosition(int position, int[] nums) {
        if(position == nums.length - 1) {
            return true;
        }

        int furthestLen = Math.min(position + nums[position], nums.length - 1);

        for(int i=position+1; i<=furthestLen; i++) {
            if(canJumpFromPosition(i, nums)){
                return true;
            }
        }
        return false;
    }


    //appraoch2 dynamic solution Top-down 自顶向下递归存储中间态
    enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;
    public boolean canJumpFromPosition2(int position, int[] nums) {
        if(memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(nums.length - 1, nums[position] + position);
        for(int i=position + 1; i<=furthestJump; i++) {
            if(canJumpFromPosition2(i, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump2(int[] nums) {
        memo = new Index[nums.length];
        for(int i=0 ;i<nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }

        memo[nums.length-1] = Index.GOOD;
        return canJumpFromPosition2(0, nums);
    }


    //approach3 dynamic solution Bottom-top 自顶向上，消除递归操作，提高性能
    public boolean canJump3(int[] nums) {
        Index[] memo3 = new Index[nums.length -1];
        for(int i=0; i<nums.length; i++) {
            memo3[i] = Index.UNKNOWN;
        }

        memo3[nums.length - 1] = Index.GOOD;

        for(int i = nums.length - 2; i >=0; i--) {
            int furthestJump = Math.min(nums.length - 1, i + nums[i]);
            for(int j= i + 1; j<=furthestJump; j++) {
                if(memo3[j] == Index.GOOD) {
                    memo3[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo3[0] == Index.GOOD;
    }


    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
}
