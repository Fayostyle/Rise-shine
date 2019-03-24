package leetcode;

public class LC55_JumpGame {
    //递归回溯
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

    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
}
