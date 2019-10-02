package SwordForOffer.Chapter2;

public class Solution_12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix.length <= 0 || str.length <= 0) return false;
        boolean [] visited = new boolean[matrix.length];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(findPath(matrix, rows, cols, i, j, str, 0, visited)) return true;
            }
        }
        return false;
    }
    public boolean findPath(char[] matrix, int rows, int cols, int row, int col, char[] str,int pathLength, boolean[] visited){
        if(pathLength == str.length) return true;
        boolean exist = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]){
            ++pathLength;
            visited[row * cols + col] = true;
            exist = findPath(matrix, rows, cols, row - 1, col, str, pathLength, visited) ||
                    findPath(matrix, rows, cols, row, col + 1, str, pathLength, visited) ||
                    findPath(matrix, rows, cols, row + 1, col, str, pathLength, visited) ||
                    findPath(matrix, rows, cols, row, col - 1, str, pathLength, visited);
            if(!exist){ //不存在则还原状态
                --pathLength;
                visited[row * cols + col] = false;
            }
        }

        return exist;
    }

    public static void main(String[] args) {
        Solution_12 a = new Solution_12();
        char [] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char [] str = {'A','B','C','C','E','D'};
        System.out.println(a.hasPath(matrix,3,4,str));
    }
}
