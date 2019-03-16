package course_ch1;

import java.util.Arrays;

public class Code001_SortSolution {

    /** 冒泡排序 **/
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    /** 选择排序 **/
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /** 插入排序 **/
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /** 归并排序 **/

    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /** 合并两个子序列 */
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for(int cur=0; cur<help.length; cur++) {
            arr[l + cur] = help[cur];
        }
    }


    /** 改进版快速排序 */
    public static void quickSort(int[] arr) {
        if(arr== null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            //骚操作1
            swap(arr, (int) (l + Math.random() * (r - l + 1)), r);
            int[] part = partion(arr, l, r);
            quickSort(arr, l, part[0] - 1);
            quickSort(arr, part[1] + 1, r);
        }
    }

    /** 得出相等区间的index范围 */
    public static int[] partion(int[] arr, int l, int r) {
        int p1 = l - 1;
        int p2 = r;
        int cur = l;
        while(cur < p2) {
            if(arr[cur] < arr[r]) {
                swap(arr, ++p1, cur++);
            } else if(arr[cur] > arr[r]) {
                swap(arr, --p2, cur);
            } else {
                cur++;
            }
        }
        //骚操作1恢复
        swap(arr, r, p2);
        return new int[]{p1 + 1, p2};
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**堆排序 */
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for(int i=0; i<arr.length; i++) {
            heapInsert(arr, i);

        }
        int size = arr.length;
        swap(arr, 0, --size);
        while(size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }

    /** 将数组按照大根堆的方式排好 */
    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /** 交换之后将变化的堆仍然调整为大根堆 */
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while(left < size) {
            //左右孩子中较大的值的index。 先判断右孩子是否越界
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;
            //如果较大的比当前index值要大，则当前数在大根堆中向下沉
            if(largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;

//            if(arr[largest] > arr[index]) {
//                swap(arr, index, largest);
//                index = largest;
//                left = index * 2 + 1;
//            } else {
//                break;
//            }
        }
    }

    /**
     * for test
     * 对数器的使用
     **/
    public static void comparator(int[] num) {
        Arrays.sort(num);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {

        int[] arr = new int[(int) (Math.random() * maxSize + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((int) (Math.random() * (maxValue + 1)) - maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null) || arr1.length != arr2.length) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArr(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(10, 20);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);

            comparator(arr1);
//            quickSort(arr2,0,arr2.length-1);
            heapSort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArr(arr);
                printArr(arr1);
                printArr(arr2);
                break;
            }
        }
        System.out.println(succeed ? "nice!" : "fuck");

        int[] arr = generateRandomArray(10, 20);
        comparator(arr);
        printArr(arr);
        heapSort(arr);
        printArr(arr);
    }
}
