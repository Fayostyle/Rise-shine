package course_ch2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code003_Stack_Queue_Convert {

    //两个栈实现队列
    public static class StackToQueue{
        private Stack<Integer> stackpush;
        private Stack<Integer> stackpop;


        public StackToQueue() {
            this.stackpop = new Stack<>();
            this.stackpush = new Stack<>();
        }

        public void push(int num) {
            stackpush.push(num);
        }

        public int peek() {
            if(stackpush.isEmpty() && stackpop.isEmpty()) {
                throw new RuntimeException("queue is empty");
            } else if(stackpop.isEmpty()) {
                while(stackpush.size() > 0) {
                    stackpop.push(stackpush.pop());
                }
            }
            return stackpop.peek();
        }

        public int poll() {
            if(stackpush.isEmpty() && stackpop.isEmpty()) {
                throw new RuntimeException("queue is empty");
            } else if(stackpop.isEmpty()) {
                while(stackpush.size() > 0) {
                    stackpop.push(stackpush.pop());
                }
            }
            return stackpop.pop();
        }
    }

    //两个队列实现栈
    public static class QueueToStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public QueueToStack() {
            this.data = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public void push(int num) {
            data.add(num);
        }

        public int peek() {
            if(data.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }

            while(data.size() > 1) {
                help.add(data.poll());
            }

            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if(data.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }

            while(data.size() > 1) {
                help.add(data.poll());
            }

            int res = data.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }

    }

}
