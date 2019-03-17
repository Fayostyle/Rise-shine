package course_ch1;

import java.util.Arrays;
import java.util.Comparator;

public class Code008_Comparator {


    public static class Student {
        public String name;
        public int age;
        public int id;

        public Student(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    public static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, 10, "zhangsan");
        Student student2 = new Student(2, 20, "lisi");

        Student[] arr = new Student[]{student1, student2};

        Arrays.sort(arr, new AgeComparator());

        for(int i=0; i<arr.length; i++) {
            System.out.println("id:" + arr[i].id + "age:" + arr[i].age + "name: " + arr[i].name);
        }

        System.out.println(firstMissingPositive(new int[]{3 ,4 , -1 ,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        for(int i=0; i<nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1] ) {
                System.out.println(nums[i]);
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

//        for(int i=0; i<nums.length; i++) {
//            if(nums[i] != i+1) {
//                return i+1;
//            }
//        }
        for(int i=0; i< nums.length; i++) {
            if(nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}


