package course_ch1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code007_MdieaQuick {

    public static class MedianHolder {
        private PriorityQueue<Integer> bigPriority = new PriorityQueue<>(new MaxHeapComparator());

        private PriorityQueue<Integer> smallPriority = new PriorityQueue<>(new MinHeapComparator());

        public void addNum(int num){
            if(this.bigPriority.isEmpty()) {
                bigPriority.add(num);
                return;
            }

            if(num <= this.bigPriority.peek()) {
                bigPriority.add(num);
            } else {
                if(this.smallPriority.isEmpty()) {
                    this.smallPriority.add(num);
                    return;
                }
                if(num >= this.smallPriority.peek()) {
                    this.smallPriority.add(num);
                } else {
                    this.bigPriority.add(num);
                }

            }
            modifyTwoPriority();

        }

        public void modifyTwoPriority() {
            if(this.bigPriority.size() - this.smallPriority.size() == 2) {
                this.smallPriority.add(this.bigPriority.poll());
            }
            if(this.smallPriority.size() - this.bigPriority.size() == 2) {
                this.bigPriority.add(this.smallPriority.poll());
            }
        }

        public Integer getMedian() {
            int bigLength = this.bigPriority.size();
            int smallLength = this.smallPriority.size();
            if (bigLength + smallLength == 0) {
                throw  new RuntimeException("没有中位数");
            }
            int bothLength = bigLength + smallLength;
            if((bothLength & 1) == 0) {
                return (this.bigPriority.peek() + this.smallPriority.peek()) / 2;
            }
            return bigLength > smallLength ? this.bigPriority.peek() : this.smallPriority.peek();
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static int getMedia(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("arr为空");
        }
        int[] newarr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newarr);
        int mid = (newarr.length - 1) / 2;
        if((newarr.length & 1) == 0) {
            return (newarr[mid+1] + newarr[mid]) / 2;
        }
        return newarr[mid];
    }

    public static void main(String[] args) {
        int testTime = 500000;
        boolean err = false;
        for(int i=0; i<testTime; i++) {
            MedianHolder medianHolder = new MedianHolder();
            int[] arr = course_ch1.Code001_SortSolution.generateRandomArray(10,10);
            for(int j=0; j<arr.length; j++) {
                medianHolder.addNum(arr[j]);
            }
            if(medianHolder.getMedian() != getMedia(arr)) {
                err = true;
                System.out.println(medianHolder.getMedian()+","+getMedia(arr));
                course_ch1.Code001_SortSolution.printArr(arr);
                break;
            }

        }
        System.out.println(err ? "fuck" : "nice");
    }
}
