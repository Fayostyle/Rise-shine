
import java.util.*;
class Lt135 {
    public static int[] candy(int[] ratings) {
		if(ratings == null || ratings.length < 1) {
			//return 0;
		}
		int[] r = new int[ratings.length];
        Arrays.fill(r, 1);
		
		boolean flag = true;
		while(flag) {
		for(int i=0; i<ratings.length; i++) {
			flag = false;
						
			/*if(i != ratings.length - 1 && ratings[i] > ratings[i+1] && r[i] <= r[i+1]) {
				r[i] = r[i+1] + 1;
				flag = true;
			}
			
			if(i > 0 &&ratings[i] > ratings[i-1] && r[i] <= r[i-1]) {
				r[i] = r[i-1] + 1;
				flag = true;
			}*/
			if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && r[i] <= r[i + 1]) {
                    r[i] = r[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && r[i] <= r[i - 1]) {
                    r[i] = r[i - 1] + 1;
                    flag = true;
                }

		}
		}
		return r;
		
		//int res = 0;
		//for(int i=0; i<r.length; i++) {
			//res += r[i];
		//}
		//return res;
    }
	
	public static int[] candy2(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    flag = true;
                }
            }
        }
		return candies;
	}
	
	public static void main(String[] args) {
	int[] nums = {1,2,87,87,87,2,1};
	
		System.out.println(Arrays.toString(candy(nums)));
				System.out.println("-------------------------------");

		System.out.println(Arrays.toString(candy2(nums)));
		System.out.println(1324);
		System.out.println("你好");
	}
	
}

/*
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    flag = true;
                }
            }
        }
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}*/


public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}

