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

    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
}
