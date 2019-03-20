package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i=1; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1);
            row.add(1);
            for(int j= 1; j<i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
}
