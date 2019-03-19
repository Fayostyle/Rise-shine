package course_ch2;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 * 回栈中最小元素的操作。
 */
public class Code_02_GetMinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        stack.push(num);
        if(minStack.isEmpty()) {
            minStack.push(num);
        } else if(num < minStack.peek()) {
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop() {
        if(stack.isEmpty()){
            throw new StackOverflowError("stack is null");
        }


        minStack.pop();
        return stack.pop();
    }

    public Integer getMin() {
        if(!minStack.isEmpty()) {
            return stack.peek();
        }
        return null;
    }

}
