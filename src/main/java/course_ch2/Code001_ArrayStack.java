package course_ch2;

/**
 * 数组结构实现栈结构和队列
 */
public class Code001_ArrayStack {

    private Integer[] arr;
    private Integer size;
    private Integer index;

    public Code001_ArrayStack(int initSize) {
        if(initSize < 0) {
            throw new IllegalArgumentException("The init size can not less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }

    public  Integer peek() {
        if(size == 0) {
            return null;
        }
        return arr[size - 1];
    }

    public void push(Integer num) {
        if(size == arr.length) {
            throw new ArrayIndexOutOfBoundsException(("stack is full"));
        }

        arr[size++] = num;
    }

    public Integer pop() {
        if(size == 0) {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
        return arr[--size];
    }


    public static class ArrayQueue {
        private Integer[] arr;
        private Integer in;
        private Integer out;
        private Integer size;

        public ArrayQueue(int initSize) {
            if(initSize < 0) {
                throw new IllegalArgumentException(("The init size can not less than 0"));
            }

            arr = new Integer[initSize];
            in = 0;
            out = 0;
            size = 0;
        }

        public void push(int num) {
            if(size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("queue is full");
            }

            arr[in] = num;
            in = (in+1) % arr.length;
            size++;
        }

        public Integer poll() {
            if(size == 0) {
                throw new ArrayIndexOutOfBoundsException("queue is empty");
            }

            int res = arr[out];
            out = (out+1) % arr.length;
            size--;
            return res;
        }

        public Integer peek() {
            if(size == 0) {
                return null;
            }

            return arr[out];
        }
    }

    public static void main(String[] args) {
        Code001_ArrayStack stack = new Code001_ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(4);

        ArrayQueue queue = new ArrayQueue(4);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.poll());
        queue.push(5);
        System.out.println(queue.poll());

        System.out.println(queue.poll());

        System.out.println(queue.poll());

        System.out.println(queue.poll());



    }
}
