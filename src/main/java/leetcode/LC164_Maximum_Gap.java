package leetcode;

public class LC164_Maximum_Gap {
        private static  long max = Integer.MIN_VALUE;
        private static long min = Integer.MAX_VALUE;
        public static int maximumGap(int[] nums) {
            if(nums == null || nums.length < 2) {
                return 0;
            }

            for(Integer num : nums) {
                max = Math.max(num, max);
                min = Math.min(num, min);
            }
            int length = nums.length;

            int[] maxValue = new int[length+1];
            int[] minValue = new int[length+1];

            boolean[] hasNumber = new boolean[length + 1];

            int bucket = 0;
            for(int i=0; i<nums.length; i++) {
                int num = nums[i];
                bucket = getBucket(num, nums);
                if(!hasNumber[bucket]) {
                    maxValue[bucket] = num;
                    minValue[bucket] = num;
                    hasNumber[bucket] = true;
                } else {
                    maxValue[bucket] = Math.max(num, maxValue[bucket]);
                    minValue[bucket] = Math.min(num, minValue[bucket]);
                }
            }

            int res = 0;
            int lastMax = maxValue[0];
            for(int i=1; i<=length; i++) {
                if(hasNumber[i]) {
                    res = Math.max(res, minValue[i] - lastMax);
                    lastMax = maxValue[i];
                }
            }
            return res;
        }

        public static int getBucket(long num, int[] nums) {
            int res = (int) ((num - min)  * nums.length / (max - min));
            return res;
        }

    public static void main(String[] args) {
        int[] nums = new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        maximumGap(nums);
    }
}
