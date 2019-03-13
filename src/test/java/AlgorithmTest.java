import leetcode.Solution;
import org.junit.Test;

public class AlgorithmTest {
    Solution solution = new Solution();
    @Test
    public void testMerge() {
        for(int i=0; i<3; i++) {
            for(int j=i+1; j<3; j++) {
                if(j==2) {
                    System.out.println("i:" + i + "j:" + j);
                    break;
                }
            }
            System.out.println("---");
        }
    }

    @Test
    public void testRemoveDup() {
        System.out.println(solution.removeDuplicates(new int[]{0,0,0,0,0}));
    }

    @Test
    public void findTest(){
        System.out.println(solution.firstMissingPositive(new int[]{1,2,3,-1,23}));
        System.out.println(-5 /2);
    }


}
