package SwordForOffer.Chapter4;

import java.util.ArrayList;

public class Solution_29 {
    /**
     * 顺时针打印矩阵
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(matrix == null || rows == 0 || cols == 0) {
            return null;
        }
        int start = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        /**画图观察可发现该规律：
         * 每一圈起点坐标总是（x,x）
         * 且能继续打印，则起点坐标一定符合(2*x < cols && 2*x < rows) */
        while(rows > start * 2 && cols > start * 2) {
            list.addAll(printCricle(matrix, cols, rows, start));
            ++start;
        }
        return list;
    }

    /**
     * 每一圈具体打印方法
     * @param matrix
     * @param cols
     * @param rows
     * @param start
     * @return 该圈的list
     */
    public ArrayList<Integer> printCricle(int [][] matrix, int cols, int rows, int start) {
        /**框定最大范围*/
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        /**方向一：从左往右
         * 无论如何都要打印*/
        for(int i = start; i <= endX; ++i) {
            list.add(matrix[start][i]);
        }
        /**方向二：从上往下
         * 打印条件：至少有两行（即endY > start）*/
        if(endY > start) {
            for(int i = start + 1; i <= endY; ++i) {
                list.add(matrix[i][endX]);
            }
        }
        /**方向三：从左往右
         * 打印条件：至少有两行两列（即endY > start && endX > start）*/
        if(endY > start && endX > start) {
            for(int i = endX - 1; i >= start; --i) {
                list.add(matrix[endY][i]);
            }
        }
        /**方向四：从下往上
         * 打印条件：至少有三行两列（即endY > start+1 && endX > start）*/
        if(endY > start+1 && endX > start) {
            for(int i = endY - 1; i > start; --i) {
                list.add(matrix[i][start]);
            }
        }
        return list;
    }
}
