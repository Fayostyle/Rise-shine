/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {


    LinkedList<NestedInteger> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for(int i = first.size() -1 ; i>=0; i--) {
                list.addFirst(first.get(i));
            }
        }

        return !list.isEmpty();
    }



    // public Iterator<Integer> iterator;

    // public NestedIterator(List<NestedInteger> nestedList) {
    //     List<Integer> list = new LinkedList<>();
    //     for(NestedInteger it : nestedList) {
    //         traverse(it, list);
    //     }
    //     this.iterator = list.iterator();
    // }

    // @Override
    // public Integer next() {
    //     return iterator.next();
        
    // }

    // @Override
    // public boolean hasNext() {
    //     return iterator.hasNext();
    // }

    // public void traverse(NestedInteger nested, List<Integer> list) {
    //     if(nested.isInteger()) {
    //         list.add(nested.getInteger());
    //         return;
    //     }
    //     for(NestedInteger l : nested.getList()) {
    //         traverse(l, list);
    //     }
    // }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

