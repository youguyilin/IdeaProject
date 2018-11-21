package algorithm;

/**
 * PackageName: algorithm
 * ClassName: DyadicArrayTwoDirectionFind
 * Author: CYP2017
 * Date: 2018/11/12 16:37
 * Description:
 */
public class DyadicArrayTwoDirectionFind {
    /**
     * 在一个数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否有这个整数。
     */
    public static void main(String[] args){
        int[][] matrix= new int[][]{
                {1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}
        };
        System.out.println(findInPartiallySortedMatrix(matrix,0));
    }


    private static int findInPartiallySortedMatrix(int[][] martrix,int key){
        int rows = martrix.length;
        int cols = martrix[0].length;
        if (martrix == null || rows < 1 || cols < 1){
            return 0;
        }
        int row = 0;
        int col = cols - 1;
        while(row < rows && col >=0){
            if (martrix[row][col] == key){
                return 1;
            }else if (martrix[row][col] < key){
                row++;
            }else {
                col--;
            }
        }
        return 0;
    }
}
