package algorithm;

/**
 * PackageName: algorithm
 * ClassName: OddFirstEventNumbers
 * Author: CYP2017
 * Date: 2018/11/8 17:00
 * Description:
 */
public class OddFirstEventNumbers {
    /**
     * 输入一个整数数组，实现一个函数来调整数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于后半部分，
     * <p>
     * O（n^2）的解法：
     * 插入排序的变形：将交换的条件判断为a(j-1)为偶，a(j)为奇数
     * O(n)的解法：
     * 两个指针：p1 = arr[0];p2 = arr[length -1]
     * while(p1 < p2){
     * p1 往右走，遇到偶数即停；
     * p2 往左走，遇到奇数即停；
     * swap(p1,p2);
     * }
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,8,5,7};
        printArr(arr);
        System.out.println("");
        reOder(arr);
        System.out.println("");
        printArr(arr);

    }

    private static void printArr(int[] arr) {
        for (int i = 0;i < arr.length; i++){
            System.out.print(arr[i] + " - ");
        }
    }

    /**
     * O（N）
     *
     * @param arr
     */
    public static void reOder(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int p1 = -1;
        int p2 = arr.length;
        while (p1 < p2){
            while(p1 < p2 && flag(arr[++p1]));
            while(p1< p2 && !flag(arr[--p2]));
            swap(arr,p1,p2);
        }
    }

    /**
     * O(N^)
     * @param arr
     */
    public static void reOderOddEventByInsertSort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        for (int i = 0;i < arr.length;i++){
            for (int j = i;j > 0&& !flag(arr[j-1]) && flag(arr[j]);j--){
                swap(arr,j-1,j);
            }
        }
    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 判断条件 i 是奇数
     * @param i
     * @return
     */
    public static boolean flag(int i){
        if (i % 2 == 0){
            return false;
        }
        return true;
    }
}
